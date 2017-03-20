package com.nc.dev3.lomako.beans.answer;

import java.io.Serializable;

/**
 * Created by arturlomako on 3/16/17.
 */
public class AnswerOption implements Serializable {

    private static final long serialVersionUID = 2520175495025108028L;
    private String text;

    public AnswerOption() { }

    public AnswerOption(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AnswerOption)) return false;

        AnswerOption that = (AnswerOption) o;

        return text != null ? text.equals(that.text) : that.text == null;
    }

    @Override
    public int hashCode() {
        return text != null ? text.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "AnswerOption{" +
                "text='" + text + '\'' +
                '}';
    }
}
