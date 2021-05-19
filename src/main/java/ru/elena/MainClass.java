package ru.elena;

import ru.elena.fruits.Apple;
import ru.elena.fruits.Fruit;
import ru.elena.fruits.Orange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainClass {
    public static void main(String[] args) {
        String[] array = {"1", "2", "3", "4"};
        Integer[] array1 = {11, 12, 13, 14};

        arrayToList(array);
        arrayToList(array1);

        changeArray(1, 2, array);
        changeArray(0, 3, array1);

        test3();

    }

    //Задача 1
    public static <Q> void changeArray(int numberElement1, int numberElement2, Q[] array) {
        Q numberElement;
        numberElement = array[numberElement1];
        array[numberElement1] = array[numberElement2];
        array[numberElement2] = numberElement;
        System.out.println(Arrays.toString(array));
    }
    //Задача 2
    public static <Q> void arrayToList(Q[] array) {
        ArrayList<Q> list = new ArrayList<>();
//        Collections.addAll(list, array);
        for (int i = 0; i < array.length; i++) {
            list.add(i, array[i]);
        }
        for (Q q : list) {
            System.out.println(q);
        }
    }

    public static void test3() {

        Apple apple = new Apple();
        Orange orange = new Orange();

        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        Box<Apple> appleBox2 = new Box<>();
        Box<Orange> orangeBox3 = new Box<>();

        for (int i = 0; i < 10; i++) {
            appleBox.addFruit(apple);
            orangeBox.addFruit(orange);
            appleBox2.addFruit(apple);
            orangeBox3.addFruit(orange);
        }

        System.out.println(appleBox.getWeight());
        System.out.println(appleBox2.getWeight());
        System.out.println(orangeBox.getWeight());

        System.out.println(appleBox.compare(appleBox2));
        System.out.println(orangeBox.compare(appleBox));
        System.out.println("****************");
        System.out.println(orangeBox.getWeight());
        orangeBox.unionBoxes(orangeBox3);
        System.out.println(orangeBox.getWeight());
        System.out.println(orangeBox3.getWeight());
    }
}
