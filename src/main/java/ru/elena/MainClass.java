package ru.elena;

import java.util.Arrays;

public class MainClass {

    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) {

        float[] arr = new float[size];

        Arrays.fill(arr, 1);
        method1(arr);
        method2(arr);

    }
    private static void method1(float[] arr) {
        long a = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math
                    .sin(0.2f + i / 5.) * Math
                    .cos(0.2f + i / 5.) * Math
                    .cos(0.4f + i / 2.));

        }
        System.out.println("method1:" + (System.currentTimeMillis() - a));
    }
    private static void method2(float[] arr) {
        float[] arr1 = new float[h];
        float[] arr2 = new float[h];

        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);

        System.out.println("Разбивка: " + (System.currentTimeMillis() - a));

        Thread thread1 = new Thread(new MyThread(arr1));
        Thread thread2 = new Thread(new MyThread(arr2));

        while (true) {
            try {
                thread1.start();
                thread2.start();
                thread1.join();
                thread2.join();
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        a = System.currentTimeMillis();

        System.arraycopy(arr1, 0, arr, 0, h);
        System.arraycopy(arr2, 0, arr, h, h);

        System.out.println("Склейка: " + (System.currentTimeMillis() - a));
    }
}
