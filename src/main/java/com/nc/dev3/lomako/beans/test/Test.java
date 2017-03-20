package com.nc.dev3.lomako.beans.test;

import com.nc.dev3.lomako.beans.strategy.ResultCalculationStrategy;
import com.nc.dev3.lomako.beans.task.Task;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by arturlomako on 3/18/17.
 */
public class Test implements Serializable {

    private static final long serialVersionUID = -5965469173441798469L;
    private String name;
    private String description;
    private List<Task> tasks;
    private ResultCalculationStrategy resultCalculationStrategy;
    private GregorianCalendar createdDate = new GregorianCalendar();

    public Test() { }

    public Test(String name, String description, List<Task> tasks, ResultCalculationStrategy strategy) {
        this.name = name;
        this.description = description;
        this.tasks = tasks;
        this.resultCalculationStrategy = strategy;
    }

    public ResultCalculationStrategy getResultCalculationStrategy() {
        return resultCalculationStrategy;
    }

    public void setResultCalculationStrategy(ResultCalculationStrategy resultCalculationStrategy) {
        this.resultCalculationStrategy = resultCalculationStrategy;
    }

    public GregorianCalendar getCreatedDate() {
        return createdDate;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Test)) return false;

        Test test = (Test) o;

        if (name != null ? !name.equals(test.name) : test.name != null) return false;
        if (description != null ? !description.equals(test.description) : test.description != null) return false;
        if (tasks != null ? !tasks.equals(test.tasks) : test.tasks != null) return false;
        if (resultCalculationStrategy != null ? !resultCalculationStrategy.equals(test.resultCalculationStrategy) : test.resultCalculationStrategy != null)
            return false;
        return createdDate != null ? createdDate.equals(test.createdDate) : test.createdDate == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (tasks != null ? tasks.hashCode() : 0);
        result = 31 * result + (resultCalculationStrategy != null ? resultCalculationStrategy.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Test{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", tasks=" + tasks +
                ", resultCalculationStrategy=" + resultCalculationStrategy +
                ", createdDate=" + createdDate +
                '}';
    }
}
