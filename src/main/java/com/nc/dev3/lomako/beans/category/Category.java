/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.nc.dev3.lomako.beans.category;

import com.nc.dev3.lomako.beans.test.Test;

import java.io.Serializable;
import java.util.List;

/**
 * This class describes entity <b>Category</b>
 * Category has got some tests
 *
 * @author lomako
 * @version 1.0
 */
public class Category implements Serializable, Comparable<Category> {

    private static final long serialVersionUID = 896381315737649861L;

    private String name;
    private List<Test> tests;

    /**
     * Creates new entity of the class <b>{@code Category}</b>
     */
    public Category() { }

    /**
     * Creates new entity of the class <b>{@code Category}</b>
     *
     * @param name name of category
     * @param tests list of tests that are in this category
     */
    public Category(String name, List<Test> tests) {
        this.name = name;
        this.tests = tests;
    }

    /**
     * @return the name of category
     * */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     * */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the list of tests
     * */
    public List<Test> getTests() {
        return tests;
    }

    /**
     * @param tests list of tests to set
     * */
    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

    /**
     * Compare two Categories by name
     *
     * @param o other category to compare
     * @see Comparable#compareTo(Object)
     * */
    @Override
    public int compareTo(Category o) {
        return name.compareTo(o.getName());
    }

    /**
     * Test two categories to equals
     *
     * @see Object#equals(Object)
     * */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;

        Category category = (Category) o;

        if (name != null ? !name.equals(category.name) : category.name != null) return false;
        return tests != null ? tests.equals(category.getTests()) : category.tests == null;
    }

    /**
     * @see Object#hashCode()
     * */
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (tests != null ? tests.hashCode() : 0);
        return result;
    }

    /**
     * @return stringify {@code Category}
     *
     * @see Object#toString()
     * */
    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", tests=" + tests +
                '}';
    }
}
