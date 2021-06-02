package ru.elena;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class MainClass {
    public static final int CARS_COUNT = 4;
    final static CountDownLatch countDownLatchStartRace = new CountDownLatch(CARS_COUNT);
    final static CountDownLatch countDownLatchStopRace = new CountDownLatch(CARS_COUNT);
    static CyclicBarrier cyclicBarrier = new CyclicBarrier(CARS_COUNT);
    final static CopyOnWriteArrayList<Car> winners = new CopyOnWriteArrayList<>();
    private static final String finalMessage = "Победители: \n 3-е место %s \n 2-е место %s \n 1-е место %s";

    public static void main(String[] args) throws InterruptedException {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }

        for (Car car : cars) {
            new Thread(car).start();
        }

        countDownLatchStartRace.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");

        countDownLatchStopRace.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");

        System.out.println(String.format(finalMessage,
                winners.get(2).getName(),
                winners.get(1).getName(),
                winners.get(0).getName()));
    }
}





