package com.nc.dev3.lomako.comparator.category;

import com.nc.dev3.lomako.beans.category.Category;

import java.util.Comparator;

/**
 * Created by arturlomako on 3/19/17.
 */
public class CategoryByCountTestsComparator implements Comparator<Category> {
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
