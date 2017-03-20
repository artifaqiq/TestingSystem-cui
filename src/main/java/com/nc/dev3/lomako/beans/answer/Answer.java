/**
 * Created by Artur Lomako on 3/18/17.
 */


package com.nc.dev3.lomako.beans.answer;

import java.io.Serializable;
import java.util.List;


public class Answer implements Serializable {

    private static final long serialVersionUID = 3320221651409738286L;
    private List<Integer> answers;

    public Answer() { }

    public Answer(List<Integer> answers) {
        this.answers = answers;
    }

    public List<Integer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Integer> answers) {
        this.answers = answers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Answer)) return false;

        Answer answer = (Answer) o;

        return answers != null ? answers.equals(answer.answers) : answer.answers == null;
    }

    @Override
    public int hashCode() {
        return answers != null ? answers.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answers=" + answers +
                '}';
    }

}
