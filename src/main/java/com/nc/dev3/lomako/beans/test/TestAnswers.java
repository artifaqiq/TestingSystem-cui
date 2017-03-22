/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */

package com.nc.dev3.lomako.beans.test;

import com.nc.dev3.lomako.beans.answer.Answer;

import java.io.Serializable;
import java.util.List;

/**
 * This class describes entity <b>TestAnswer</b>
 * This entity persist answers to test, which user answered
 *
 * @author lomako
 * @version 1.0
 * @see Test
 * @see Answer
 */
public class TestAnswers implements Serializable {

    private static final long serialVersionUID = -7636354692640817460L;

    private Test test;
    private List<Answer> answers;

    /**
     * Creates new entity of the class <b>{@code TestAnswers}</b>
     */
    public TestAnswers() { }

    /**
     * Creates new entity of the class <b>{@code Category}</b>
     * @param test reference on test, which was solved
     * @param answers answers to this test
     */
    public TestAnswers(Test test, List<Answer> answers) {
        this.test = test;
        this.answers = answers;
    }

    /**
     * @return list of answers
     * */
    public List<Answer> getAnswers() {
        return answers;
    }

    /**
     * @param answers list of answers to set
     * */
    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    /**
     * @return test
     * */
    public Test getTest() {
        return test;
    }

    /**
     * @param test to set
     * */
    public void setTest(Test test) {
        this.test = test;
    }

    /**
     * Test two TestAnswers to equals
     * @see Object#equals(Object)
     * */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TestAnswers)) return false;

        TestAnswers that = (TestAnswers) o;

        if (test != null ? !test.equals(that.test) : that.test != null) return false;
        return answers != null ? answers.equals(that.answers) : that.answers == null;
    }

    /**
     * @see Object#hashCode()
     * */
    @Override
    public int hashCode() {
        int result = test != null ? test.hashCode() : 0;
        result = 31 * result + (answers != null ? answers.hashCode() : 0);
        return result;
    }

    /**
     * @return stringify {@code TestAnswers}
     * @see Object#toString()
     * */
    @Override
    public String toString() {
        return "TestAnswers{" +
                "test=" + test +
                ", answers=" + answers +
                '}';
    }
}
