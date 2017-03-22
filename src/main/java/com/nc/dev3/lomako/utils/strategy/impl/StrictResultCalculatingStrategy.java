/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */

package com.nc.dev3.lomako.utils.strategy.impl;

import com.nc.dev3.lomako.beans.answer.Answer;
import com.nc.dev3.lomako.beans.task.Task;
import com.nc.dev3.lomako.beans.test.Test;
import com.nc.dev3.lomako.beans.test.TestAnswers;
import com.nc.dev3.lomako.utils.strategy.ResultCalculationStrategy;

import java.util.ListIterator;

/**
 * Implementation {@code ResultCalculationStrategy}
 * This strategy match {@link com.nc.dev3.lomako.enums.ResultCalculationStrategyWays#STRICT}
 *
 * @see ResultCalculationStrategy
 * @see com.nc.dev3.lomako.enums.ResultCalculationStrategyWays#STRICT
 * */
public final class StrictResultCalculatingStrategy implements ResultCalculationStrategy {

    @Override
    public int calculateResult(Test test, TestAnswers testAnswers) {
        ListIterator<Task> taskIterator = test.getTasks().listIterator();
        ListIterator<Answer> answerIterator = testAnswers.getAnswers().listIterator();

        int result = 0;

        while (taskIterator.hasNext() && answerIterator.hasNext()) {
            Task task = taskIterator.next();
            Answer correctAnswer = task.getCorrectAnswer();
            Answer userAnswer = answerIterator.next();

            if(correctAnswer.getAnswers().containsAll(userAnswer.getAnswers())) {
                result += task.getPointsForCorrectAnswer();
            }
        }

        return result;
    }

    @Override
    public int calculateMaxResult(Test test) {
        ListIterator<Task> taskIterator = test.getTasks().listIterator();

        int result = 0;

        while (taskIterator.hasNext()) {
            Task task = taskIterator.next();
            result += task.getPointsForCorrectAnswer();
        }

        return result;
    }
}
