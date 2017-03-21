package com.nc.dev3.lomako.dao.category;

import com.nc.dev3.lomako.beans.category.Category;
import com.nc.dev3.lomako.dao.exceptions.NoFindEntityException;
import com.nc.dev3.lomako.dao.exceptions.UniqueIdentifierException;

import java.util.List;

/**
 * Created by arturlomako on 3/18/17.
 */
public interface CategoryDao {
    Category save(Category category) throws UniqueIdentifierException;
    List<Category> findAll();
    Category findByName(String name);
    boolean isNameAlreadyExists(String name);
    void deleteById(int id) throws NoFindEntityException;
    Category update(Category category) throws NoFindEntityException;
}
