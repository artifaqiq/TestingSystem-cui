package com.nc.dev3.lomako.cui.menu;

import java.io.PrintStream;

/**
 * Created by arturlomako on 3/19/17.
 */
public abstract class Menu {
    protected PrintStream writer = System.out;
    protected static final String CRITICAL_FAIL_MESSAGE = "Что-то пошло не так :( Нужно читать логи (log.txt)";

    public abstract void show();
}
