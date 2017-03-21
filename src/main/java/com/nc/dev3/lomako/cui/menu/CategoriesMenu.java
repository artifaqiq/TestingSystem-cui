package com.nc.dev3.lomako.cui.menu;

import com.nc.dev3.lomako.beans.category.Category;
import com.nc.dev3.lomako.dao.Dao;
import com.nc.dev3.lomako.dao.exceptions.NoFindEntityException;
import com.nc.dev3.lomako.dao.exceptions.UniqueIdentifierException;
import com.nc.dev3.lomako.utils.Logger;

import java.util.ArrayList;
import java.util.List;

import static com.nc.dev3.lomako.cui.utils.IoUtils.*;

/**
 * Created by arturlomako on 3/19/17.
 */
public final class CategoriesMenu extends Menu {
    private Dao<Category> categoryDao;

    public CategoriesMenu(Dao<Category> categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public void show() {

        while (true) {
            writer.println("   Категории");
            writer.println("   ---------");
            writer.println("1. Показать все");
            writer.println("2. Добавить новую");
            writer.println("3. Отсортировать");
            writer.println("4. Выбрать");
            writer.println("5. Удалить");
            writer.println("0. Выйти\n");

            int choice = inputNumber(0, 5);

            switch (choice) {
                case 1:
                    showAll();
                    break;
                case 2:
                    addNewCategory();
                    break;
                case 3:
                    new SortCategoriesMenu(categoryDao).show();
                    break;
                case 4:
                    Category category = choiceCategory();
                    if (category != null) {
                        new TestsMenu(categoryDao, category).show();
                    }
                    break;
                case 5:
                    deleteById();
                    break;
                case 0:
                    return;
            }

            printSeparator();
        }

    }

    private void showAll() {
        List<Category> all = categoryDao.findAll();

        if (all.size() == 0) {
            writer.println("Не имеется ни одной категории");
            return;
        }
        writer.println("\n   Все категории");

        for (int i = 0; i < all.size(); i++) {
            String wordToPrint;

            writer.printf("%d. ", i + 1);
            writer.print(all.get(i).getName());

            int countTests = all.get(i).getTests().size();
            wordToPrint = "тест";
            if (countTests % 10 == 0 || (countTests % 10 >= 5 && countTests % 10 <= 9) ||
                    ((countTests >= 10 && countTests <= 14))) {
                wordToPrint = "тестов";
            } else if ((countTests < 10 || countTests > 14) && countTests % 10 != 1) {
                wordToPrint = "теста";
            }

            writer.printf(" (%d %s);\n", countTests, wordToPrint);
        }
    }

    private void addNewCategory() {
        Category category = new Category();
        String name;

        writer.println("Название: ");

        while (true) {
            name = inputString();
            if (categoryDao.isNameAlreadyExists(name)) {
                writer.println("Такое название уже существует");
                writer.println("Название:");
            } else {
                break;
            }
        }

        category.setTests(new ArrayList<>());
        category.setName(name);

        try {
            categoryDao.save(category);
        } catch (UniqueIdentifierException e) {
            writer.println("Категория с таким названием уже существует");
            Logger.getInstance().log(e);
        }

        writer.println("Добавлено !");
    }

    private void deleteById() {
        List<Category> all = categoryDao.findAll();
        int id;

        if (all.size() == 0) {
            writer.println("Не имеется ни одной категории");
            return;
        }

        writer.print("Id = ");
        id = inputNumber(1, all.size());

        try {
            categoryDao.deleteById(id - 1);
            writer.println("Удалено !");
        } catch (NoFindEntityException e) {
            writer.println(CRITICAL_FAIL_MESSAGE);
            Logger.getInstance().log(e);
        }

    }

    private Category choiceCategory() {
        List<Category> all = categoryDao.findAll();
        int id;

        if (all.size() == 0) {
            writer.println("Не имеется ни одной категории");
            return null;
        }

        writer.print("Id = ");
        id = inputNumber(1, all.size()) - 1;

        return all.get(id);
    }

}
