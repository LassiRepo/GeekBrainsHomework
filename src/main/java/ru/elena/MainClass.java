package ru.elena;

import java.util.Arrays;

import static ru.elena.ArrayToTest.checkArray;
import static ru.elena.ArrayToTest.createArray;

//2. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
//        Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
//        идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку, иначе в методе
//        необходимо выбросить RuntimeException. Написать набор тестов для этого метода (по 3-4 варианта входных данных).
//        Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
//        3. Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть одной четверки или
//        единицы, то метод вернет false; Если в массиве есть числа отличные от 1 и 4, то метод выбрасывает RuntimeException;
//        Написать набор тестов для этого метода (по 3-4 варианта входных данных).

public class MainClass {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 4, 4, 2, 3, 4, 1, 7};
        int[] array2 = {1, 2, 4, 4, 2, 3, 0, 1, 4};
        int[] array3 = {4, 2, 5, 7, 2, 3, 7, 1, 7};
        System.out.println(Arrays.toString(createArray(array1)));
        System.out.println(Arrays.toString(createArray(array2)));
        System.out.println(Arrays.toString(createArray(array3)));
        System.out.println(checkArray(new int[]{1, 1, 4, 4, 1, 4}));
        System.out.println(checkArray(new int[]{1, 1, 1, 1, 1, 1}));
        System.out.println(checkArray(new int[]{1, 1, 4, 4, 1, 4, 0, 9}));
    }

}

