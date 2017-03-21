package com.nc.dev3.lomako.comparator.category;

import com.nc.dev3.lomako.beans.category.Category;

import java.util.Comparator;

/**
 * Created by arturlomako on 3/19/17.
 */
public class CategoryByNameComparator implements Comparator<Category> {
    @Override
    public int compare(Category o1, Category o2) {
        return o1.getName().compareToIgnoreCase(o2.getName());
    }


}
