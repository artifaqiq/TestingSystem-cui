/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.nc.dev3.lomako.dao.category.impl;

import com.nc.dev3.lomako.beans.category.Category;
import com.nc.dev3.lomako.dao.Dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Implementation {@code Dao} for category entities.
 * Use temporary memory structures as data storage.
 * All data will be lost after program exit.
 *
 * @see Dao
 *
 * @author lomako
 * @version 1.0
 * */
public final class TemporaryCategoryDao implements Dao<Category> {

    private static volatile Dao<Category> instance;
    private List<Category> categories = new ArrayList<>();

    private TemporaryCategoryDao() {
    }

    @Override
    public Category save(Category category) {
        categories.add((Category) category);
        Collections.sort(categories);
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
        return categories;
    }

    @Override
    public void deleteById(int id) throws NoSuchElementException {
        if (id < 0 || id >= categories.size()) {
            throw new NoSuchElementException("Category with id = " + id + " doesn't exists");
        }
        categories.remove(id);
    }

    @Override
    public Category update(Category category) {
        int index = (Collections.binarySearch(categories, category));
        if (index < 0) {
            return null;
        }
        categories.set(index, category);

        return category;

    }

    public static Dao<Category> getInstance() throws IOException {
        if (instance == null) {
            synchronized (TemporaryCategoryDao.class) {
                if (instance == null) {
                    instance = new TemporaryCategoryDao();
                }
            }
        }
        return instance;
    }
}
