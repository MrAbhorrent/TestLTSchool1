package com.bellintegrator.lt.school;

import java.util.Scanner;

public class View {
    Scanner scanner = new Scanner(System.in);

    public int inputINTValue(String string) {
        int result = 0;
        System.out.print(string);
        result = scanner.nextInt(); // TODO: проверка что введенное число является целым
        return result;
    }

//    public String[] inputRowArray() {
//        System.out.println("Введите символы через пробел");
//        while (scanner.hasNextLine()) {
//            String readRow = scanner.nextLine();
//            String[] arraySymbols = readRow.split(" ");
//            return arraySymbols;
//        }
//        return null;
//    }

    // Для вывода на экран
    public void print2DArray(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("%2s", array[i][j]);
            }
            System.out.println();
        }
    }
}
