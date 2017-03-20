package com.nc.dev3.lomako.utils;

import com.nc.dev3.lomako.beans.answer.Answer;
import com.nc.dev3.lomako.beans.answer.AnswerOption;
import com.nc.dev3.lomako.beans.category.Category;
import com.nc.dev3.lomako.beans.strategy.ScaledResultCalculatingStrategy;
import com.nc.dev3.lomako.beans.strategy.StrictResultCalculatingStrategy;
import com.nc.dev3.lomako.beans.task.Task;
import com.nc.dev3.lomako.beans.test.Test;
import com.nc.dev3.lomako.beans.test.TestAnswers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arturlomako on 3/20/17.
 */
public class BeansCreator {
    public Category createExampleCategory() {

        Category category = new Category();
        List<Test> tests = new ArrayList<>();

        List<Task> tasks1 = new ArrayList<>();
        List<Task> tasks2 = new ArrayList<>();

        Task task1 = new Task();
        Task task2 = new Task();
        Task task3 = new Task();

        List<AnswerOption> options1 = new ArrayList<>();
        List<AnswerOption> options2 = new ArrayList<>();
        List<AnswerOption> options3 = new ArrayList<>();

        Answer answer1 = new Answer();
        Answer answer2 = new Answer();
        Answer answer3 = new Answer();

        List<Integer> answersIndexes1 = new ArrayList<>();
        List<Integer> answersIndexes2 = new ArrayList<>();
        List<Integer> answersIndexes3 = new ArrayList<>();

        options1.add(new AnswerOption("Да"));
        options1.add(new AnswerOption("Нет"));

        options2.add(new AnswerOption("Java"));
        options2.add(new AnswerOption("С++"));
        options2.add(new AnswerOption("Asm"));

        options3.add(new AnswerOption("MySQL"));
        options3.add(new AnswerOption("PgSQL"));
        options3.add(new AnswerOption("MongoDB"));

        answersIndexes1.add(0);
        answersIndexes2.add(0);
        answersIndexes3.add(0);
        answersIndexes3.add(1);

        answer1.setAnswers(answersIndexes1);
        answer2.setAnswers(answersIndexes2);
        answer3.setAnswers(answersIndexes3);

        task1.setText("Любишь кодярить?");
        task1.setOptions(options1);
        task1.setCorrectAnswer(answer1);
        task1.setPointsForCorrectAnswer(100);

        task2.setText("Кроссплатформенность?");
        task2.setOptions(options2);
        task2.setCorrectAnswer(answer2);
        task2.setPointsForCorrectAnswer(200);

        task3.setText("Какие реляционные?");
        task3.setOptions(options3);
        task3.setCorrectAnswer(answer3);
        task3.setPointsForCorrectAnswer(400);

        tasks1.add(task1);
        tasks1.add(task2);
        tasks2.add(task3);

        tests.add(new Test(
                "Чуть-чуть о программировании",
                "Тут описание должно быть",
                tasks1,
                new StrictResultCalculatingStrategy()));

        tests.add(new Test(
                "Чуть-чуть о бд",
                "Нужно пояснить о базах данных",
                tasks2,
                new ScaledResultCalculatingStrategy()));

        category.setName("Категория обо всем");
        category.setTests(tests);

        return category;
    }

    public TestAnswers createExampleTestAnswers() {
        TestAnswers testAnswers = new TestAnswers();
        List<Answer> answers = new ArrayList<>();

        Answer answer1 = new Answer();
        Answer answer2 = new Answer();

        List<Integer> answerIndexes1 = new ArrayList<>();
        List<Integer> answerIndexes2 = new ArrayList<>();

        answerIndexes1.add(0);
        answerIndexes2.add(1);

        answer1.setAnswers(answerIndexes1);
        answer2.setAnswers(answerIndexes2);

        answers.add(answer1);
        answers.add(answer2);

        testAnswers.setAnswers(answers);
        testAnswers.setTest(createExampleCategory().getTests().get(0));

        return testAnswers;

    }
}
