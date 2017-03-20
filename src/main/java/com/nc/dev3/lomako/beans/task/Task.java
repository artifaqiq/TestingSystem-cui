package com.nc.dev3.lomako.beans.task;

import com.nc.dev3.lomako.beans.answer.Answer;
import com.nc.dev3.lomako.beans.answer.AnswerOption;

import java.io.Serializable;
import java.util.List;

/**
 * Created by arturlomako on 3/16/17.
 */
public class Task implements Serializable {

    private static final long serialVersionUID = 2286987032535820733L;
    private String text;
    private int pointsForCorrectAnswer;
    private Answer correctAnswer;
    private List<AnswerOption> options;

    public Task() {
    }

    public Task(String text, int pointsForCorrectAnswer, Answer correctAnswer, List<AnswerOption> options) {
        this.text = text;
        this.pointsForCorrectAnswer = pointsForCorrectAnswer;
        this.correctAnswer = correctAnswer;
        this.options = options;
    }

    public Answer getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(Answer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPointsForCorrectAnswer() {
        return pointsForCorrectAnswer;
    }

    public void setPointsForCorrectAnswer(int pointsForCorrectAnswer) {
        this.pointsForCorrectAnswer = pointsForCorrectAnswer;
    }

    public List<AnswerOption> getOptions() {
        return options;
    }

    public void setOptions(List<AnswerOption> options) {
        this.options = options;
    }

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

    @Override
    public int hashCode() {
        int result = text != null ? text.hashCode() : 0;
        result = 31 * result + pointsForCorrectAnswer;
        result = 31 * result + (correctAnswer != null ? correctAnswer.hashCode() : 0);
        result = 31 * result + (options != null ? options.hashCode() : 0);
        return result;
    }

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
