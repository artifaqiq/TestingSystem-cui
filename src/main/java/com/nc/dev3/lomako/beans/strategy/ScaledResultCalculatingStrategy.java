package com.nc.dev3.lomako.beans.strategy;

import com.nc.dev3.lomako.utils.AnswerResult;

import java.io.Serializable;

/**
 * Created by arturlomako on 3/17/17.
 */
public class ScaledResultCalculatingStrategy implements ResultCalculationStrategy, Serializable {

    private static final long serialVersionUID = -8859028833176395528L;

    @Override
    public int calculateResult(AnswerResult answerResult, int points) {
        return answerResult.getCountCorrectAnswersUser() * points;
    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ScaledResultCalculatingStrategy;
    }

    @Override
    public String toString() {
        return "ScaledResultCalculatingStrategy{}";
    }
}
