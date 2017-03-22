/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.nc.dev3.lomako.dao.category.impl;

import com.esotericsoftware.yamlbeans.YamlConfig;
import com.nc.dev3.lomako.beans.test.Test;
import com.nc.dev3.lomako.beans.answer.AnswerOption;
import com.nc.dev3.lomako.beans.category.Category;
import com.nc.dev3.lomako.dao.exceptions.NoFindEntityException;
import com.nc.dev3.lomako.enums.ResultCalculationStrategyWays;
import com.nc.dev3.lomako.beans.task.Task;
import com.esotericsoftware.yamlbeans.YamlReader;
import com.esotericsoftware.yamlbeans.YamlWriter;
import com.nc.dev3.lomako.dao.Dao;
import com.nc.dev3.lomako.dao.exceptions.UniqueIdentifierException;
import com.nc.dev3.lomako.utils.Logger;

import java.io.*;
import java.util.*;

/**
 * Implementation {@code Dao} for category entities.
 * Use Yaml-format file as data storage.
 *
 * @see Dao
 *
 * @author lomako
 * @version 1.0
 * */
public final class YamlFileCategoryDao implements Dao<Category> {

    private static volatile Dao<Category> instance;

    private static final String DIR_PATH = "data_source";
    private static final String FILE_PATH = "categories.yml";
    private static final File file = new File(DIR_PATH
            + File.separator
            + FILE_PATH);

    private static final Map<Class, String> YAML_CONFIG = new HashMap<>();
    private static final String CRITICAL_STORAGE_FILES_PROBLEM_MESSAGE =
            "Возникла проблема с доступом к файлу с базой данных. Обратитесь к администратору.";

    static {
        YAML_CONFIG.put(Category.class, "category");
        YAML_CONFIG.put(Test.class, "test");
        YAML_CONFIG.put(Task.class, "task");
        YAML_CONFIG.put(AnswerOption.class, "option");
        YAML_CONFIG.put(ResultCalculationStrategyWays.class, "strategy");
        YAML_CONFIG.put(GregorianCalendar.class, "date");

    }

    private YamlFileCategoryDao() throws IOException {
        if (!file.exists()) {

            File baseDir = new File(DIR_PATH);
            if (!baseDir.exists()) {
                if (!baseDir.mkdir()) {
                    throw new IOException(file.getAbsolutePath() + " can not be created");
                }
            }

            if (!file.createNewFile()) {
                throw new IOException(file.getAbsolutePath() + " can not be created");
            }
        }

        if (file.length() == 0L) {
            List<Category> emptyList = new ArrayList<>();
            saveAll(emptyList);
        }
    }

    private void updateYamlConfig(YamlConfig config) {

        config.setClassTag(YAML_CONFIG.get(Test.class), Test.class);
        config.setClassTag(YAML_CONFIG.get(Task.class), Task.class);
        config.setClassTag(YAML_CONFIG.get(AnswerOption.class), AnswerOption.class);
        config.setClassTag(YAML_CONFIG.get(Category.class), Category.class);
        config.setClassTag(YAML_CONFIG.get(ResultCalculationStrategyWays.class), ResultCalculationStrategyWays.class);
        config.setClassTag(YAML_CONFIG.get(GregorianCalendar.class), GregorianCalendar.class);
    }

    @Override
    public Category save(Category category) throws UniqueIdentifierException {
        List<Category> categories = findAll();

        if (exists(category.getName(), categories)) {
            throw new UniqueIdentifierException("Category with name " + category.getName() + " already exists");
        }
        categories.add(category);
        saveAll(categories);

        return category;
    }

    @Override
    public boolean isNameAlreadyExists(String name) {
        return findByName(name) != null;
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
    public List<Category> findAll() {
        List<Category> categories = null;
        YamlReader reader = null;

        try {
            reader = new YamlReader(new FileReader(file));
            updateYamlConfig(reader.getConfig());
            categories = (List<Category>) reader.read(List.class);

        } catch (IOException e) {
            System.err.println(CRITICAL_STORAGE_FILES_PROBLEM_MESSAGE);
            Logger.getInstance().log(e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.err.println(CRITICAL_STORAGE_FILES_PROBLEM_MESSAGE);
                    Logger.getInstance().log(e);
                }
            }
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
            throw new NoFindEntityException("Category (" + category.toString() + ") doesn't find");
        }
        all.set(index, category);
        saveAll(all);

        return category;

    }

    private void saveAll(List<Category> categories) {
        try {
            Collections.sort(categories);

            YamlWriter writer = new YamlWriter(new FileWriter(file));
            updateYamlConfig(writer.getConfig());

            writer.write(categories);
            writer.close();

        } catch (IOException e) {
            System.err.println(CRITICAL_STORAGE_FILES_PROBLEM_MESSAGE);
            Logger.getInstance().log(e);
        }
    }

    private boolean exists(String name, List<Category> all) {
        for (Category category : all) {
            if (category.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static Dao<Category> getInstance() throws IOException {
        if (instance == null) {
            synchronized (YamlFileCategoryDao.class) {
                if (instance == null) {
                    instance = new YamlFileCategoryDao();
                }
            }
        }
        return instance;
    }
}
