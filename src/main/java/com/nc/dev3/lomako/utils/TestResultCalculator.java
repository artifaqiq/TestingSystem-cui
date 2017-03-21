package com.nc.dev3.lomako.utils;

import com.nc.dev3.lomako.beans.test.Test;
import com.nc.dev3.lomako.beans.answer.Answer;
import com.nc.dev3.lomako.beans.test.TestAnswers;
import com.nc.dev3.lomako.beans.task.Task;

import java.util.List;
import java.util.ListIterator;

/**
 * Created by arturlomako on 3/17/17.
 */
public class TestResultCalculator {
    public static int calculateTestResult(TestAnswers testAnswers) {

        Test test = testAnswers.getTest();
        ListIterator<Task> taskIterator = test.getTasks().listIterator();
        ListIterator<Answer> answerIterator = testAnswers.getAnswers().listIterator();
        int result = 0;

        while(taskIterator.hasNext() && answerIterator.hasNext()) {
            Task currentTask = taskIterator.next();

            List<Integer> correctAnswers = currentTask.getCorrectAnswer().getAnswers();
            List<Integer> userAnswers = answerIterator.next().getAnswers();
            AnswerResult answerResult = new AnswerResult(correctAnswers.size(), 0);

            for(int i = 0; i < correctAnswers.size(); i++) {
                if(userAnswers.contains(correctAnswers.get(i))) {
                    answerResult.setCountCorrectAnswersUser(answerResult.getCountCorrectAnswersUser() + 1);
                }
            }

            result += test.getResultCalculationStrategy().calculateResult(
                    answerResult, currentTask.getPointsForCorrectAnswer());

        }

        return result;
    }

    public static int calculateMaxTestResult(Test test) {
        ListIterator<Task> taskIterator = test.getTasks().listIterator();
        int result = 0;

        while(taskIterator.hasNext()) {
            Task task = taskIterator.next();

            result += test.getResultCalculationStrategy().calculateResult(
                    new AnswerResult(task.getCorrectAnswer().getAnswers().size(),
                            task.getCorrectAnswer().getAnswers().size()), task.getPointsForCorrectAnswer());
        }

        return result;
    }
}
