package ru.elena;

import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();


    }

    //1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    // С помощью цикла и условия заменить 0 на 1, 1 на 0;
    public static void task1() {
        int[] nums = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = 1;
            } else if (nums[i] == 1) {
                nums[i] = 0;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
    //2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;

    public static void task2() {
        int[] mas = new int[8];

        for (int i = 0; i < mas.length; i++) {
            if (i == 0) {
                mas[i] = 0;
            } else {
                mas[i] = mas[i - 1] + 3;
            }

        }

        System.out.println(Arrays.toString(mas));
    }

    //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
    public static void task3() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] = arr[i] * 2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    //4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое)
    // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
    public static void task4() {
        int[][] square = new int[5][5];
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square[i].length; j++) {
                if (i == j) {
                    square[i][j] = 1;
                } else if (square[i].length - j - 1 == i) {
                    square[square.length - 1 - j][j] = 1;
                }
            }
        }
        printSquare(square);
    }

    public static void printSquare(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    //5. Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
    public static void task5() {
        int arr[] = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9};
        int max = 0;
        int min = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                max = arr[i];
                min = arr[i];
            }
            if (max < arr[i]) {
                max = arr[i];
            }
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        System.out.println("Максимальное значение: " + max);
        System.out.println("Минимальное значение: " + min);
    }
}


