/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.nc.dev3.lomako.comparator.category;

import com.nc.dev3.lomako.beans.category.Category;

import java.util.Comparator;

/**
 * This class implement interface {@code Comparator}
 * May be used for sort collections of categories by name
 *
 * @author lomako
 * @version 1.0
 * @see Comparator
 * */
public class CategoryByNameComparator implements Comparator<Category> {

    /**
     * Compare two categories by name
     *
     * @see Comparator#compare(Object, Object)
     * */
    @Override
    public int compare(Category o1, Category o2) {
        return o1.getName().compareToIgnoreCase(o2.getName());
    }


}
