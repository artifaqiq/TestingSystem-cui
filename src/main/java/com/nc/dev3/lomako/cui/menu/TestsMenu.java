package com.nc.dev3.lomako.cui.menu;

import com.nc.dev3.lomako.beans.answer.Answer;
import com.nc.dev3.lomako.beans.answer.AnswerOption;
import com.nc.dev3.lomako.beans.category.Category;
import com.nc.dev3.lomako.enums.ResultCalculationStrategyWays;
import com.nc.dev3.lomako.utils.strategy.ResultCalculationStrategyCreator;
import com.nc.dev3.lomako.beans.task.Task;
import com.nc.dev3.lomako.beans.test.Test;
import com.nc.dev3.lomako.beans.test.TestAnswers;
import com.nc.dev3.lomako.dao.Dao;
import com.nc.dev3.lomako.dao.exceptions.NoFindEntityException;
import com.nc.dev3.lomako.utils.Logger;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static com.nc.dev3.lomako.cui.utils.IoUtils.*;

/**
 * Created by arturlomako on 3/19/17.
 */
public final class TestsMenu extends Menu {

    private Dao<Category> categoryDao;
    private Category currentCategory;
    private PrintStream writer = System.out;

    public TestsMenu(Dao<Category> categoryDao, Category currentCategory) {
        this.categoryDao = categoryDao;
        this.currentCategory = currentCategory;
    }

    @Override
    public void show() {
        while (true) {
            writer.println(" -- Тесты в категории " + currentCategory.getName());
            writer.println("1. Показать все тесты");
            writer.println("2. Добавить новый тест");
            writer.println("3. Начать решать тест");
            writer.println("4. Удалить тест");
            writer.println("0. Назад");

            int choice = inputNumber(0, 4);

            switch (choice) {
                case 1:
                    showAll();
                    break;
                case 2:
                    addNewTest();
                    break;
                case 3:
                    solveTest();
                    break;
                case 4:
                    deleteTestById();
                    break;
                case 0:
                    return;
            }

            printSeparator();
        }
    }

    private void showAll() {
        List<Test> tests = currentCategory.getTests();

        if (tests.size() == 0) {
            writer.println("В данной категории пока нету тестов");
        } else {
            writer.println("  Тесты");
            writer.println("  ------");

            for (int i = 0; i < tests.size(); i++) {
                writer.printf("%d. %s\n", i + 1, tests.get(0).getName());
            }
        }
    }

    private void addNewTest() {
        ResultCalculationStrategyWays strategy;

        writer.print("Название: ");
        String name = inputString();

        writer.print("Описание: ");
        String description = inputString();

        writer.println("Выберите стратегию проверки результата");
        writer.println("1. Лояльная (В заданиях с несколькими правильными ответами будет учитываться каждый отдельный правильный ответ)");
        writer.println("2. Строгая (Если в задании не совпадает хотя бы один ответ - задание считается проваленным)");

        if (inputNumber(1, 2) == 1) {
            strategy = ResultCalculationStrategyWays.SCALED;
        } else {
            strategy = ResultCalculationStrategyWays.STRICT;
        }

        List<Task> tasks = new ArrayList<>();

        for (int taskIndex = 0; ; taskIndex++) {
            if (taskIndex > 0) {
                writer.println("1. Добавить задание");
                writer.println("0. Готово");
                int addOrCancel = inputNumber(0, 1);
                if (addOrCancel == 0) break;
            }

            writer.printf("Задание %d:\n", taskIndex + 1);
            writer.print("Описание задания: ");
            String text = inputString();

            writer.println("Варианты ответов: ");

            List<AnswerOption> options = new ArrayList<>();
            for (int optionIndex = 0; ; optionIndex++) {
                if (optionIndex > 0) {
                    writer.println("1. Добавить вариант ответа");
                    writer.println("0. Готово");
                    int addOrCancel = inputNumber(0, 1);
                    if (addOrCancel == 0) break;
                }

                writer.printf("Вариант %d: ", optionIndex + 1);
                options.add(new AnswerOption(inputString()));
            }

            writer.println("Правильные ответы: ");
            List<Integer> answers = new ArrayList<>();
            for (int answerIndex = 0; answers.size() < options.size(); answerIndex++) {
                if (answerIndex > 0) {
                    writer.println("1. Добавить правильный ответ");
                    writer.println("0. Готово");
                    int addOrCancel = inputNumber(0, 1);
                    if (addOrCancel == 0) break;
                }

                writer.printf("Правильный ответ %d: ", answerIndex + 1);
                while (true) {
                    int correctAnswer = inputNumber(1, options.size()) - 1;
                    if (answers.contains(correctAnswer)) {
                        writer.println("Уже было");
                    } else {
                        answers.add(correctAnswer);
                        break;
                    }
                }

            }

            writer.print("Очков за правильный ответ: ");
            int points = inputNumber(0, 1000);

            tasks.add(new Task(text, points, new Answer(answers), options));
        }

        Test test = new Test(name, description, tasks, strategy);

        currentCategory.getTests().add(test);
        try {
            categoryDao.update(currentCategory);
            writer.println("Сохранено !");
        } catch (NoFindEntityException e) {
            writer.println(CRITICAL_FAIL_MESSAGE);
            Logger.getInstance().log(e);
        }

    }

    private void solveTest() {
        if (currentCategory.getTests().size() == 0) {
            writer.println("В данной категории нету тестов :(");
            return;
        }

        writer.print("Id: ");
        Test test = currentCategory.getTests().get(inputNumber(1, currentCategory.getTests().size()) - 1);
        printSeparator();
        writer.println("Вы начали тест. Всего " + test.getTasks().size() + " заданий");

        TestAnswers testAnswers = new TestAnswers(test, new ArrayList<>());

        for (int taskIndex = 0; taskIndex < test.getTasks().size(); taskIndex++) {
            Task task = test.getTasks().get(taskIndex);
            writer.printf("%d. %s\n", taskIndex + 1, task.getText());

            writer.println("Варианты ответов:");
            for (int optionIndex = 0; optionIndex < task.getOptions().size(); optionIndex++) {
                writer.printf("%d. %s\n", optionIndex + 1, task.getOptions().get(optionIndex).getText());
            }

            writer.printf("Введите номера правильных ответов (Всего правильных ответов: %d)\n",
                    task.getCorrectAnswer().getAnswers().size());

            List<Integer> answers = new ArrayList<>();
            for (int answerIndex = 0; answerIndex < task.getCorrectAnswer().getAnswers().size(); answerIndex++) {
                writer.printf("Ответ %d: ", answerIndex + 1);
                int input = inputNumber(1, task.getOptions().size()) - 1;

                if (answers.contains(input)) {
                    writer.println("Уже было");
                    answerIndex--;
                    continue;
                }

                answers.add(input);
            }
            testAnswers.getAnswers().add(new Answer(answers));
        }

        writer.println("Ваш результат: "
                + ResultCalculationStrategyCreator.create(test.getResultCalculationStrategyWay())
                .calculateResult(test, testAnswers)
                + " / "
                + ResultCalculationStrategyCreator.create(test.getResultCalculationStrategyWay())
                .calculateMaxResult(test));

    }

    private void deleteTestById() {
        if (currentCategory.getTests().size() == 0) {
            writer.println("В данной категории нету тестов :(");
            return;
        }

        writer.print("Id: ");
        int index = inputNumber(1, currentCategory.getTests().size()) - 1;
        currentCategory.getTests().remove(index);
        try {
            List<Category> all = categoryDao.findAll();

            for (int i = 0; i < all.size(); i++) {
                if(all.get(i).getName().equals(currentCategory.getName())) {
                    categoryDao.deleteById(i);
                    categoryDao.save(currentCategory);
                    break;
                }
            }

        } catch (Exception e) {
            writer.println(CRITICAL_FAIL_MESSAGE);
            Logger.getInstance().log(e);
        }

        writer.println("Удалено");
    }
}
