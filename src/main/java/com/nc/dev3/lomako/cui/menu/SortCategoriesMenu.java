package com.nc.dev3.lomako.cui.menu;

import com.nc.dev3.lomako.beans.category.Category;
import com.nc.dev3.lomako.comparator.category.CategoryComparatorCreator;
import com.nc.dev3.lomako.cui.utils.IoUtils;
import com.nc.dev3.lomako.dao.Dao;
import com.nc.dev3.lomako.enums.CategorySortWays;

import java.util.Comparator;
import java.util.List;

/**
 * Created by arturlomako on 3/19/17.
 */
public final class SortCategoriesMenu extends Menu {

    private Dao<Category> categoryDao;

    public SortCategoriesMenu(Dao<Category> categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public void show() {
        List<Category> all = categoryDao.findAll();
        Comparator<Category> comparator;

        if (all.size() == 0) {
            writer.println("Не имеется ни одной категории");
            return;
        }

        while (true) {
            writer.println();
            writer.println("1. По имени");
            writer.println("2. По количеству тестов");
            writer.println("0. Назад");

            int choice = IoUtils.inputNumber(0, 2);
            CategorySortWays sortWay = null;

            switch (choice) {
                case 1:
                    sortWay = CategorySortWays.BY_NAME;
                    break;
                case 2:
                    sortWay = CategorySortWays.BY_COUNT_TESTS;
                    break;
                case 0:
                    return;
                default:
                    continue;
            }

            comparator = CategoryComparatorCreator.create(sortWay);
            all.sort(comparator);

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
                        (( countTests <= 14 && countTests >= 10))) {
                    wordToPrint = "тестов";
                } else if ((countTests < 10 || countTests > 14) && countTests % 10 != 1) {
                    wordToPrint = "теста";
                }

                writer.printf(" (%d %s);\n", countTests, wordToPrint);
            }

            IoUtils.printSeparator();
        }
    }
}
