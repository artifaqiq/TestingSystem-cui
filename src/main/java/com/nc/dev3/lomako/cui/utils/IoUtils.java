package com.nc.dev3.lomako.cui.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by arturlomako on 3/19/17.
 */
public class IoUtils {

    /**
     *
     * @param rangeLeft Left limit of range of valid values incl.
     * @param rangeRight Right limit of range of valid values incl.
     * @return
     */

    public static int inputNumber(int rangeLeft, int rangeRight) {
        int number = -1;
        while(true){
            try {
                Scanner input = new Scanner(System.in);
                number = input.nextInt();
                if(number >= rangeLeft && number <= rangeRight){
                    return number;
                }
                else {
                    System.out.printf("Введите число от %d до %d включительно\n", rangeLeft, rangeRight);
                }

            }
            catch (InputMismatchException e) {
                System.out.println("Неверный формат. Повторите ввод...");
            }
        }
    }

    /**
     * String input
     * @return string
     */
    public static String inputString() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public static void printSeparator() {
        System.out.println(" **********************************\n");
    }

}
