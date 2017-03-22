/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.nc.dev3.lomako.beans.test;

import com.nc.dev3.lomako.beans.task.Task;
import com.nc.dev3.lomako.enums.ResultCalculationStrategyWays;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * This class describes entity <b>Test</b>
 *
 * @author lomako
 * @version 1.0
 * @see Test
 */
public class Test implements Serializable {

    /**
     * This variable is counter of created instances of this class
     * */
    public static int numberOfEntities = 0;

    private static final long serialVersionUID = -5965469173441798469L;

    private String name;
    private String description;
    private List<Task> tasks;
    private ResultCalculationStrategyWays resultCalculationStrategyWay;
    private GregorianCalendar createdDate = new GregorianCalendar();

    /**
     * Creates new entity of the class <b>{@code Test}</b>
     */
    public Test() {
        Test.numberOfEntities++;
    }

    /**
     * Creates new entity of the class <b>{@code Test}</b>
     *
     * @param name name of test
     * @param description descriptions of test
     * @param tasks list of tasks that are in this test
     * @param resultCalculationStrategyWay way to calculate test result
     *                                     @see ResultCalculationStrategyWays
     *
     */
    public Test(String name, String description, List<Task> tasks,
                ResultCalculationStrategyWays resultCalculationStrategyWay) {
        numberOfEntities++;

        this.name = name;
        this.description = description;
        this.tasks = tasks;
        this.resultCalculationStrategyWay = resultCalculationStrategyWay;
    }

    /**
     * @return way to calculate test result
     *
     * @see ResultCalculationStrategyWays
     * */
    public ResultCalculationStrategyWays getResultCalculationStrategyWay() {
        return resultCalculationStrategyWay;
    }

    /**
     * @param resultCalculationStrategyWay way to calculate test result
     *
     * @see ResultCalculationStrategyWays
     * */
    public void setResultCalculationStrategyWay(ResultCalculationStrategyWays resultCalculationStrategyWay) {
        this.resultCalculationStrategyWay = resultCalculationStrategyWay;
    }

    /**
     * @return date then entity was saved
     * */
    public GregorianCalendar getCreatedDate() {
        return createdDate;
    }


    /**
     * @return list of tasks
     * */
    public List<Task> getTasks() {
        return tasks;
    }


    /**
     * @param tasks list of tasks to set
     * */
    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }


    /**
     * @return name of test
     * */
    public String getName() {
        return name;
    }

    /**
     * @param name name of c
     * */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return description of test
     * */
    public String getDescription() {
        return description;
    }

    /**
     * @param description description of test
     * */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Test two tests to equals
     *
     *  @see Object#equals(Object)
     * */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Test)) return false;

        Test test = (Test) o;

        if (name != null ? !name.equals(test.name) : test.name != null) return false;
        if (description != null ? !description.equals(test.description) : test.description != null) return false;
        if (tasks != null ? !tasks.equals(test.tasks) : test.tasks != null) return false;
        if (resultCalculationStrategyWay != test.resultCalculationStrategyWay) return false;
        return createdDate != null ? createdDate.equals(test.createdDate) : test.createdDate == null;
    }

    /**
     * @see Object#hashCode()
     * */
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (tasks != null ? tasks.hashCode() : 0);
        result = 31 * result + (resultCalculationStrategyWay != null ? resultCalculationStrategyWay.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        return result;
    }

    /**
     * @return stringify {@code }
     *
     * @see Object#toString()
     * */
    @Override
    public String toString() {
        return "Test{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", tasks=" + tasks +
                ", resultCalculationStrategyWay=" + resultCalculationStrategyWay +
                ", createdDate=" + createdDate +
                '}';
    }
}
