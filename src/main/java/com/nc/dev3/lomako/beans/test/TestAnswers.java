package com.nc.dev3.lomako.beans.test;

import com.nc.dev3.lomako.beans.answer.Answer;

import java.io.Serializable;
import java.util.List;

/**
 * Created by arturlomako on 3/18/17.
 */
public class TestAnswers implements Serializable {

    private static final long serialVersionUID = -7636354692640817460L;

    private Test test;
    private List<Answer> answers;

    public TestAnswers() { }

    public TestAnswers(Test test, List<Answer> answers) {
        this.test = test;
        this.answers = answers;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TestAnswers)) return false;

        TestAnswers that = (TestAnswers) o;

        if (test != null ? !test.equals(that.test) : that.test != null) return false;
        return answers != null ? answers.equals(that.answers) : that.answers == null;
    }

    @Override
    public int hashCode() {
        int result = test != null ? test.hashCode() : 0;
        result = 31 * result + (answers != null ? answers.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TestAnswers{" +
                "test=" + test +
                ", answers=" + answers +
                '}';
    }
}
