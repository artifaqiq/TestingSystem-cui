package com.nc.dev3.lomako.beans.strategy;

import com.nc.dev3.lomako.utils.AnswerResult;

/**
 * Created by arturlomako on 3/17/17.
 */
public interface ResultCalculationStrategy {
    int calculateResult(AnswerResult answerResult, int points);
}
