/**
 * Created by Artur Lomako on 3/18/17.
 */
package com.nc.dev3.lomako.beans.answer;

import java.io.Serializable;
import java.util.List;

/**
 * This class describes entity <b>Answer</b>
 *
 * @author lomako
 * @version 1.0
 */
public class Answer implements Serializable {

    private static final long serialVersionUID = 3320221651409738286L;

    private List<Integer> answers;

    /**
     * Creates new entity of the class <b>{@code Answer}</b>
     */
    public Answer() { }

    /**
     * Creates new entity of the class <b>{@code Answer}</b>
     *
     * @param answers list of numbers of answer. Every number correspond with one answer option
     */
    public Answer(List<Integer> answers) {
        this.answers = answers;
    }

    /**
     * @return list of numbers of answer
     * */
    public List<Integer> getAnswers() {
        return answers;
    }

    /**
     * @param answers list of numbers of answer
     * */
    public void setAnswers(List<Integer> answers) {
        this.answers = answers;
    }


    /**
     * Test two answers to equals
     *
     * @see Object#equals(Object)
     * */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Answer)) return false;

        Answer answer = (Answer) o;

        return answers != null ? answers.equals(answer.answers) : answer.answers == null;
    }

    /**
     * @see Object#hashCode()
     * */
    @Override
    public int hashCode() {
        return answers != null ? answers.hashCode() : 0;
    }

    /**
     * @return stringify {@code Answer}
     *
     * @see Object#toString()
     * */
    @Override
    public String toString() {
        return "Answer{" +
                "answers=" + answers +
                '}';
    }

}
