package ru.elena;

public class MyThread extends Thread {

    private float[] array;

    public MyThread(float[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        long a = System.currentTimeMillis();

        for (int i = 0; i <array.length ; i++) {
            array[i] = (float)(array[i] * Math
                    .sin(0.2f + i / 5.) * Math
                    .cos(0.2f + i / 5.) * Math
                    .cos(0.4f + i / 2.));

        }

        System.out.println("Работа " +
                currentThread().getName() +
                ": " +
                (System.currentTimeMillis() - a));
    }
}
