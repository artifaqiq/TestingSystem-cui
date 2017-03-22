/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */

package com.nc.dev3.lomako.dao;

import com.nc.dev3.lomako.dao.exceptions.NoFindEntityException;
import com.nc.dev3.lomako.dao.exceptions.UniqueIdentifierException;

import java.util.List;

/**
 * Data access object describe CRUD operations on entities with data storage
 *
 * @author lomako
 * @version 1.0
 * */
public interface Dao<T>  {

    /**
     * Save item to storage
     *
     * @param item item for save
     * @return saved item if saving was successful
     *
     * @throws UniqueIdentifierException if there is item with same unique identifier
     * */
    T save(T item) throws UniqueIdentifierException;

    /**
     * Get all items from storage
     *
     * @return list of all items
     * */
    List<T> findAll();

    /**
     * Find item by name in storage
     *
     * @param name name for find
     *
     * @return found item
     * */
    T findByName(String name);

    /**
     * Check if an element exists
     *
     * @param name name for find
     *
     * @return true if name exists
     *         false if name doesn't exists
     * */
    boolean isNameAlreadyExists(String name);

    /**
     * Delete element by id
     *
     * @param id id
     *
     * @throws NoFindEntityException if entity not found
     * */
    void deleteById(int id) throws NoFindEntityException;

    /**
     * Update existing item
     *
     * @param item item for update
     *
     * @return updated item
     *
     * @throws NoFindEntityException if item not found
     * */
    T update(T item) throws NoFindEntityException;
}
