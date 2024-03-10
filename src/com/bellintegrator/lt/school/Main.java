package com.bellintegrator.lt.school;

public class Main {

    public static void main(String[] args) {
        int N, M;
        View view = new View();
        // Создание матрицы N x M (ограничение 1 <= N <= 100, 1 <= M <= 100)
        N = checkInputValue(view, "Введите количество строк: ");
        M = checkInputValue(view, "Введите количество столбцов: ");
        String[][] array = new String[N][M];
        fillTestArray(view, array);
        //String[][] array = MockArray.fillTestArrayMock();  // Вариант проверки 1
        //String[][] array = MockArray.fillTestArrayMock2(); // Вариант проверки 2
        findClearPositionsInArray(array);
        view.printText("OUTPUT");
        view.print2DArray(array);
        view.printText(String.format("\nКоличество способов = %2d", findClearPositionsInArray(array)));
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

    private static void fillTestArray(View view, String[][] array) {
        for (int i = 0; i < array.length; i++) {
            String[] strings = array[i];
            String[] arraySymbols = view.inputRowArray(i);
            System.arraycopy(arraySymbols, 0, strings, 0, strings.length);
        }
    }

    private static int checkInputValue(View view, String str) {
        int result;
        int minValue = 1;
        int maxValue = 100;
        while (true) {
            result = view.inputINTValue(str);
            if ( result >= minValue && result <= maxValue) {
                break;
            } else {
                view.printText(String.format("Число должно быть в диапазоне от %3d до %3d\n", minValue, maxValue));
            }
        }
        return result;
    }
}
