/**
 * Copyright (c) 2017, Lomako. All rights reserved.
 */
package com.nc.dev3.lomako.utils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * This singleton write logs
 * Default path to log file is ./log.txt
 * */
public final class Logger {

    private static Logger instance = new Logger();

    private static final String FILE_PATH = "log.txt";
    private File file = new File(FILE_PATH);

    private static final String LOG_FILES_PROBLEM_MESSAGE =
            "Возникла проблема с доступом к файлу логирования " + FILE_PATH + ". Обратитесь к администратору.";

    private Logger() {
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println(LOG_FILES_PROBLEM_MESSAGE);
            }
        }
    }

    public void log(final Throwable exception){
        final StringWriter errors = new StringWriter();
        exception.printStackTrace(new PrintWriter(errors));

        try(PrintWriter printwriter = new PrintWriter(new BufferedWriter(new FileWriter(file, true)))){
            final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            printwriter.println(sdf.format(GregorianCalendar.getInstance().getTime()));
            printwriter.println(exception.getMessage());
            printwriter.println(errors.toString());
        } catch (IOException e) {
            Logger.getInstance().log(e);
        }
    }

    public void log(final String message){
        try(PrintWriter printwriter = new PrintWriter(new BufferedWriter(new FileWriter(file, true)))){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            printwriter.println(sdf.format(GregorianCalendar.getInstance().getTime()));
            printwriter.println(message);

        } catch (IOException e) {
            Logger.getInstance().log(e);
        }
    }

    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }
}
