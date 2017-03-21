package com.nc.dev3.lomako.utils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by arturlomako on 3/19/17.
 */
public final class Logger {
    private static Logger instance = new Logger();
    private File file = new File("log.txt");


    private Logger() {
        if(!file.exists()) {
            try {


                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Writes log in file
     * @param exception - the entity of Throwable
     */
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

    /**
     * Writes log in file
     * @param message - string
     */
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
