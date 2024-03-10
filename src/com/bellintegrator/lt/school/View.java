package com.bellintegrator.lt.school;

import java.util.Scanner;

public class View {
    Scanner scanner = new Scanner(System.in);

    public int inputINTValue(String string) {
        int result;
        System.out.print(string);
        result = scanner.nextInt(); // TODO: проверка что введенное число является целым
        scanner.nextLine();
        return result;
    }

    public String[] inputRowArray(int i) {

        System.out.printf("Введите символы через пробел\nСтрока - %2d\n", i);
        String readRow = scanner.nextLine();
        String[] arraySymbols = readRow.split(" ");
        return arraySymbols;
    }

    // Для вывода на экран
    public void print2DArray(String[][] array) {
        for (String[] strings : array) {
            for (String string : strings) {
                System.out.printf("%2s", string);
            }
            System.out.println();
        }
    }

    public void printText(String str) {
        System.out.println(str);
    }
}
