/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.nc.dev3.lomako.beans.answer;

import java.io.Serializable;

/**
 * This class describes entity <b>AnswerOption</b>
 *
 * @author lomako
 * @version 1.0
 */
public class AnswerOption implements Serializable {

    private static final long serialVersionUID = 2520175495025108028L;

    private String text;

    /**
     * Creates new entity of the class <b>{@code AnswerOption}</b>
     */
    public AnswerOption() { }

    /**
     * Creates new entity of the class <b>{@code AnswerOption}</b>
     *
     * @param text text which describes one answer option
     */
    public AnswerOption(String text) {
        this.text = text;
    }


    /**
     * @return text which describes one answer option
     * */
    public String getText() {
        return text;
    }


    /**
     * @param text text which describes one answer option
     * */
    public void setText(String text) {
        this.text = text;
    }


    /**
     * Test two answer options to equals
     *
     * @see Object#equals(Object)
     * */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AnswerOption)) return false;

        AnswerOption that = (AnswerOption) o;

        return text != null ? text.equals(that.text) : that.text == null;
    }

    /**
     * @see Object#hashCode()
     * */
    @Override
    public int hashCode() {
        return text != null ? text.hashCode() : 0;
    }


    /**
     * @return stringify {@code AnswerOption}
     *
     * @see Object#toString()
     * */
    @Override
    public String toString() {
        return "AnswerOption{" +
                "text='" + text + '\'' +
                '}';
    }
}
