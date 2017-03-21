package com.nc.dev3.lomako.comparator.category;

import com.nc.dev3.lomako.beans.category.Category;
import com.nc.dev3.lomako.enums.CategorySortWays;

import java.util.Comparator;

/**
 * Created by arturlomako on 3/19/17.
 */
public class CategoryComparatorCreator {

    private CategoryComparatorCreator() { }

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
