package com.nc.dev3.lomako;

import com.nc.dev3.lomako.beans.category.Category;
import com.nc.dev3.lomako.cui.menu.CategoriesMenu;
import com.nc.dev3.lomako.dao.Dao;
import com.nc.dev3.lomako.dao.category.impl.YamlFileCategoryDao;
import com.nc.dev3.lomako.utils.Logger;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {

        Dao<Category> categoryDao = null;
        CategoriesMenu mainMenu;

        try {
            categoryDao = YamlFileCategoryDao.getInstance();

        } catch (IOException e) {
            System.err.println("Упс. Кажется, что-то пошло не так. Нужно смотреть логи.");
            Logger.getInstance().log(e);
            return;
        }

        mainMenu = new CategoriesMenu(categoryDao);
        mainMenu.show();
    }
}
