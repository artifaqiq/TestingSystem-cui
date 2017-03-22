/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.nc.dev3.lomako.beans.task;

import com.nc.dev3.lomako.beans.answer.Answer;
import com.nc.dev3.lomako.beans.answer.AnswerOption;

import java.io.Serializable;
import java.util.List;

/**
 * This class describes entity <b>Task</b>
 *
 * @author lomako
 * @version 1.0
 */
public class Task implements Serializable {

    private static final long serialVersionUID = 2286987032535820733L;

    private String text;
    private int pointsForCorrectAnswer;
    private Answer correctAnswer;
    private List<AnswerOption> options;

    /**
     * Creates new entity of the class <b>{@code Task}</b>
     */
    public Task() { }

    /**
     * Creates new entity of the class <b>{@code Category}</b>
     *
     * @param text text which describes task
     * @param pointsForCorrectAnswer number of points that get user for correct answer on this task
     * @param correctAnswer correct answer to this task
     * @param options list of options for this task
     */
    public Task(String text, int pointsForCorrectAnswer, Answer correctAnswer, List<AnswerOption> options) {
        this.text = text;
        this.pointsForCorrectAnswer = pointsForCorrectAnswer;
        this.correctAnswer = correctAnswer;
        this.options = options;
    }

    /**
     * @return the correct answer for this task
     * */
    public Answer getCorrectAnswer() {
        return correctAnswer;
    }

    /**
     * @param correctAnswer correct answer for this task to set
     * */
    public void setCorrectAnswer(Answer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    /**
     * @return text which describes this task
     * */
    public String getText() {
        return text;
    }


    /**
     * @param text text which describes this task to set
     * */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return number of points that get user for correct answer on this task
     * */
    public int getPointsForCorrectAnswer() {
        return pointsForCorrectAnswer;
    }

    /**
     * @param pointsForCorrectAnswer number of points that get user for correct answer on this task to set
     * */
    public void setPointsForCorrectAnswer(int pointsForCorrectAnswer) {
        this.pointsForCorrectAnswer = pointsForCorrectAnswer;
    }

    /**
     * @return list of options for this task
     * */
    public List<AnswerOption> getOptions() {
        return options;
    }

    /**
     * @param options list of options for this task to set
     * */
    public void setOptions(List<AnswerOption> options) {
        this.options = options;
    }


    /**
     * Test two tasks to equals
     *
     * @see Object#equals(Object)
     * */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;

        Task task = (Task) o;

        if (pointsForCorrectAnswer != task.pointsForCorrectAnswer) return false;
        if (text != null ? !text.equals(task.text) : task.text != null) return false;
        if (correctAnswer != null ? !correctAnswer.equals(task.correctAnswer) : task.correctAnswer != null)
            return false;
        return options != null ? options.equals(task.options) : task.options == null;
    }

    /**
     * @see Object#hashCode()
     * */
    @Override
    public int hashCode() {
        int result = text != null ? text.hashCode() : 0;
        result = 31 * result + pointsForCorrectAnswer;
        result = 31 * result + (correctAnswer != null ? correctAnswer.hashCode() : 0);
        result = 31 * result + (options != null ? options.hashCode() : 0);
        return result;
    }

    /**
     * @return stringify {@code Category}
     *
     * @see Object#toString()
     * */
    @Override
    public String toString() {
        return "Task{" +
                "text='" + text + '\'' +
                ", pointsForCorrectAnswer=" + pointsForCorrectAnswer +
                ", correctAnswer=" + correctAnswer +
                ", options=" + options +
                '}';
    }
}
