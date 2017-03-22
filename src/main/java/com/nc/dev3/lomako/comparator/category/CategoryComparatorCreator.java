/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.nc.dev3.lomako.comparator.category;

import com.nc.dev3.lomako.beans.category.Category;
import com.nc.dev3.lomako.enums.CategorySortWays;

import java.util.Comparator;

/**
 * This class is factory for generating strategies comparators
 *
 * @author lomako
 * @version 1.0
 *
 * @see CategoryByCountTestsComparator
 * @see CategoryByNameComparator
 * @see CategorySortWays
 */
public class CategoryComparatorCreator {

    /**
     * closed constructor
     * */
    private CategoryComparatorCreator() { }

    /**
     * @param way way for compare two categories
     * @return implementation of {@code Comparator<Strategy>}
     * */
    public static Comparator<Category> create(CategorySortWays way) {
        Comparator<Category> result = null;

        switch (way) {
            case BY_COUNT_TESTS:
                result = new CategoryByCountTestsComparator();
                break;
            case BY_NAME:
                result = new CategoryByNameComparator();
        }

        return result;
    }
}
