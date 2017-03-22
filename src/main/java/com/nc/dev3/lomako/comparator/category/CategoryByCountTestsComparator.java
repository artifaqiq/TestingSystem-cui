/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.nc.dev3.lomako.comparator.category;

import com.nc.dev3.lomako.beans.category.Category;

import java.util.Comparator;

/**
 * This class implement interface {@code Comparator}
 * May be used for sort collections of categories by count of tests
 *
 * @author lomako
 * @version 1.0
 * @see Comparator
 * */
public class CategoryByCountTestsComparator implements Comparator<Category> {

    /**
     * Compare two categories by count of tests
     *
     * @see Comparator#compare(Object, Object)
     * */
    @Override
    public int compare(Category o1, Category o2) {
        int size1 = o1.getTests().size();
        int size2 = o2.getTests().size();

        if(size1 > size2) {
            return 1;
        } else if (size1 < size2) {
            return -1;
        } else {
            return 0;
        }
    }
}
