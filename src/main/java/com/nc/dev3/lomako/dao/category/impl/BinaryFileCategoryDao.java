/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.nc.dev3.lomako.dao.category.impl;

import com.nc.dev3.lomako.beans.category.Category;
import com.nc.dev3.lomako.dao.Dao;
import com.nc.dev3.lomako.dao.exceptions.NoFindEntityException;
import com.nc.dev3.lomako.utils.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Implementation {@code Dao} for category entities.
 * Use binary file as data storage.
 *
 * @see Dao
 *
 * @author lomako
 * @version 1.0
 * */
public final class BinaryFileCategoryDao implements Dao<Category> {

    private static volatile Dao<Category> instance;

    private static final String DIR_PATH = "data_source";
    private static final String FILE_PATH = "categories.bin";
    private static final File file = new File(DIR_PATH
            + File.separator
            + FILE_PATH);

    private static final String CRITICAL_STORAGE_FILES_PROBLEM_MESSAGE =
            "Возникла проблема с доступом к файлу с базой данных. Обратитесь к администратору.";


    private BinaryFileCategoryDao() throws IOException {

        File baseDir = new File(DIR_PATH);
        if (!baseDir.exists()) {
            if (!baseDir.mkdir()) {
                throw new IOException(file.getAbsolutePath() + " can not be created");
            }
        }

        if (!file.exists()) {
            if (!file.createNewFile()) {
                throw new IOException(file.getAbsolutePath() + " can not be created");
            }
        }

        if (file.length() == 0L) {
            List<Category> emptyList = new ArrayList<>();
            saveAll(emptyList);
        }
    }

    @Override
    public Category save(Category category) {
        List<Category> categories = findAll();

        categories.add(category);
        saveAll(categories);

        return category;
    }

    @Override
    public Category findByName(String name) {
        List<Category> categories = findAll();
        int index = Collections.binarySearch(categories, new Category(name, null));

        if (index < 0) {
            return null;
        }

        return categories.get(index);
    }

    @Override
    public boolean isNameAlreadyExists(String name) {
        return findByName(name) != null;
    }

    @Override
    public List<Category> findAll() {
        List<Category> categories = null;

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
            categories = (List<Category>) inputStream.readObject();
        } catch (Exception e) {
            Logger.getInstance().log(e);
        }

        return categories;
    }

    @Override
    public void deleteById(int id) throws NoFindEntityException {
        List<Category> categories = findAll();

        if (id < 0 || id >= categories.size()) {
            throw new NoFindEntityException("Category with id = " + id + " doesn't exists");
        }
        categories.remove(id);
        saveAll(categories);
    }

    @Override
    public Category update(Category category) throws NoFindEntityException{
        List<Category> all = findAll();
        int index = (Collections.binarySearch(all, category));

        if (index < 0) {
            throw new NoFindEntityException("Category " + category + " doesn't exists");
        }
        all.set(index, category);
        saveAll(all);

        return category;

    }

    private void saveAll(List<Category> categories) {
        try {
            Collections.sort(categories);

            if (!file.delete() || !file.createNewFile()) {
                throw new IOException(file.getAbsolutePath() + " can not be deleted");
            }
        } catch (IOException e) {
            System.err.println(CRITICAL_STORAGE_FILES_PROBLEM_MESSAGE);
            Logger.getInstance().log(e);
        }

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            outputStream.writeObject(categories);

        } catch (IOException e) {
            System.err.println(CRITICAL_STORAGE_FILES_PROBLEM_MESSAGE);
            Logger.getInstance().log(e);
        }
    }

    public static Dao<Category> getInstance() throws IOException {
        if (instance == null) {
            synchronized (BinaryFileCategoryDao.class) {
                if (instance == null) {
                    instance = new BinaryFileCategoryDao();
                }
            }
        }
        return instance;
    }
}