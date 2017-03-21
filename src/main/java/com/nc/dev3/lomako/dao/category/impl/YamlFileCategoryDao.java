package com.nc.dev3.lomako.dao.category.impl;

import com.nc.dev3.lomako.beans.test.Test;
import com.nc.dev3.lomako.beans.answer.AnswerOption;
import com.nc.dev3.lomako.beans.category.Category;
import com.nc.dev3.lomako.beans.strategy.ScaledResultCalculatingStrategy;
import com.nc.dev3.lomako.beans.strategy.StrictResultCalculatingStrategy;
import com.nc.dev3.lomako.beans.task.Task;
import com.esotericsoftware.yamlbeans.YamlReader;
import com.esotericsoftware.yamlbeans.YamlWriter;
import com.nc.dev3.lomako.dao.Dao;
import com.nc.dev3.lomako.dao.exceptions.UniqueIdentifierException;

import java.io.*;
import java.util.*;

/**
 * Created by arturlomako on 3/18/17.
 */
public final class YamlFileCategoryDao implements Dao<Category> {

    private static volatile Dao<Category> instance;

    private static final String DIR_PATH = "data_source";
    private static final String FILE_PATH = "categories.yml";
    private static final File file = new File(DIR_PATH
            + File.separator
            + FILE_PATH);

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

            reader.getConfig().setClassTag("test", Test.class);
            reader.getConfig().setClassTag("task", Task.class);
            reader.getConfig().setClassTag("option", AnswerOption.class);
            reader.getConfig().setClassTag("scaled", ScaledResultCalculatingStrategy.class);
            reader.getConfig().setClassTag("strict", StrictResultCalculatingStrategy.class);
            reader.getConfig().setClassTag("category", Category.class);
            reader.getConfig().setClassTag("date", GregorianCalendar.class);
            reader.getConfig().setClassTag("integer", Integer.class);

            categories = (List<Category>) reader.read(List.class);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return categories;
    }

    @Override
    public void deleteById(int id) throws NoSuchElementException {
        List<Category> categories = findAll();

        if (id < 0 || id >= categories.size()) {
            throw new NoSuchElementException("Category with id = " + id + " doesn't exists");
        }
        categories.remove(id);
        saveAll(categories);
    }

    @Override
    public Category update(Category category) {
        List<Category> all = findAll();
        int index = (Collections.binarySearch(all, category));

        if (index < 0) {
            throw new NoSuchElementException("Category (" + category.toString() + ") doesn't find");
        }
        all.set(index, category);
        saveAll(all);

        return category;

    }

    private void saveAll(List<Category> categories) {
        try {
            Collections.sort(categories);

            YamlWriter writer = new YamlWriter(new FileWriter(file));
            writer.getConfig().setClassTag("test", Test.class);
            writer.getConfig().setClassTag("task", Task.class);
            writer.getConfig().setClassTag("option", AnswerOption.class);
            writer.getConfig().setClassTag("scaled", ScaledResultCalculatingStrategy.class);
            writer.getConfig().setClassTag("strict", StrictResultCalculatingStrategy.class);
            writer.getConfig().setClassTag("category", Category.class);
            writer.getConfig().setClassTag("date", GregorianCalendar.class);
            writer.getConfig().setClassTag("integer", Integer.class);

            writer.write(categories);
            writer.close();


        } catch (Exception e) {
            e.printStackTrace();
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
