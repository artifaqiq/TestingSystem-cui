package com.nc.dev3.lomako.beans.category;

import com.nc.dev3.lomako.beans.test.Test;

import java.io.Serializable;
import java.util.List;

/**
 * Created by arturlomako on 3/18/17.
 */
public class Category implements Serializable, Comparable<Category> {

    private static final long serialVersionUID = 896381315737649861L;
    private String name;
    private List<Test> tests;

    public Category() { }

    public Category(String name, List<Test> tests) {
        this.name = name;
        this.tests = tests;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

    @Override
    public int compareTo(Category o) {
        return name.compareTo(o.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;

        Category category = (Category) o;

        if (name != null ? !name.equals(category.name) : category.name != null) return false;
        return tests != null ? tests.equals(category.getTests()) : category.tests == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (tests != null ? tests.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", tests=" + tests +
                '}';
    }
}
