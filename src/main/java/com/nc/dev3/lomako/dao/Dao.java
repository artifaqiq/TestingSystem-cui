package com.nc.dev3.lomako.dao;

import com.nc.dev3.lomako.beans.category.Category;
import com.nc.dev3.lomako.dao.exceptions.NoFindEntityException;
import com.nc.dev3.lomako.dao.exceptions.UniqueIdentifierException;

import java.util.List;

/**
 * Created by arturlomako on 3/18/17.
 */
public interface Dao<T>  {
    T save(T item) throws UniqueIdentifierException;
    List<T> findAll();
    Category findByName(String name);
    boolean isNameAlreadyExists(String name);
    void deleteById(int id) throws NoFindEntityException;
    T update(T item) throws NoFindEntityException;
}
