package com.nc.dev3.lomako.beans.strategy;

import com.nc.dev3.lomako.utils.AnswerResult;

import java.io.Serializable;

/**
 * Created by arturlomako on 3/17/17.
 */
public class StrictResultCalculatingStrategy implements ResultCalculationStrategy, Serializable {

    private static final long serialVersionUID = 4573236045700956788L;

    @Override
    public int calculateResult(AnswerResult answerResult, int points) {
        return answerResult.getCountCorrectAnswersTotal() == answerResult.getCountCorrectAnswersUser() ? points : 0;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof StrictResultCalculatingStrategy;
    }

    @Override
    public String toString() {
        return "StrictResultCalculatingStrategy{}";
    }
}
