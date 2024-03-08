package com.bellintegrator.lt.school;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int N, M;
        View view = new View();
        // Создание матрицы N x M (ограничение 1 <= N <= 100, 1 <= M <= 100)
        N = checkInputValue(view);
        M = checkInputValue(view);
        String[][] array = new String[N][M];
        //fillTestArray(array, view);
        array = fillTestArrayMock();
        findClearPositionsInArray(array);
        System.out.println("OUTPUT");
        view.print2DArray(array);
        System.out.printf("\nКоличество способов = %2d", findClearPositionsInArray(array));
    }

    private static String[][] fillTestArrayMock() {
        return new String[][] {
                {"*","*","*","*"},
                {"*","*","-","-"},
                {"*","-","-","-"},
                {"*","-","-","-"},
        };
    }

    private static String[][] fillTestArrayMock2() {
        return new String[][] {
                {"*","*","*","*","*"},
                {"*","-","-","-","*"},
                {"*","-","-","-","*"},
                {"*","-","-","-","*"},
                {"*","*","*","*","*"},
        };
    }

    private static int findClearPositionsInArray(String[][] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j].equals("-")) {
                    if (checkPosition(array, i, j)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private static boolean checkPosition(String[][] array, int i, int j) {
        boolean result = false;
        if (i == 0) {
            if (j == 0) {
                return array [i + 1][j].equals("-")
                        && array[i][j + 1].equals("-");
            } else if (j == array[i].length - 1) {
                return array [i + 1][j].equals("-")
                        && array[i][j - 1].equals("-");
            } else {
                return array [i + 1][j].equals("-")
                        && array[i][j - 1].equals("-")
                        && array[i][j + 1].equals("-");
            }
        }
        if (i == array.length - 1) {
            if (j == 0) {
                return array [i - 1][j].equals("-")
                        && array[i][j + 1].equals("-");
            } else if (j == array[i].length - 1) {
                return array [i - 1][j].equals("-")
                        && array[i][j - 1].equals("-");
            } else {
                return array [i - 1][j].equals("-")
                        && array[i][j - 1].equals("-")
                        && array[i][j + 1].equals("-");
            }
        }
        if (j == 0) {
            return (array[i - 1][j].equals("-")
                    && array [i + 1][j].equals("-")
                    && array[i][j + 1].equals("-"));
        } else if (j == array[i].length - 1) {
            return  (array[i - 1][j].equals("-")
                    && array [i + 1][j].equals("-")
                    && array[i][j - 1].equals("-"));
        }
        return  (array[i - 1][j].equals("-")
                && array [i + 1][j].equals("-")
                && array[i][j - 1].equals("-")
                && array[i][j + 1].equals("-"));
    }

    private static void fillTestArray(String[][] array, View _view) {
        for (int i = 0; i < array.length; i++) {
            Scanner scanner = new Scanner(System.in);
            String readRow = scanner.nextLine();
            String[] arraySymbols = readRow.split(" ");
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = arraySymbols[j];
            }
        }
    }

    private static int checkInputValue(View view) {
        int result;
        while (true) {
            result = view.inputINTValue("Введите количество строк: ");
            if ( result >= 1 && result <= 100) {
                break;
            } else {
                System.out.println("Число должно быть в диапазоне от 1 до 100");
            }
        }
        return result;
    }



}
