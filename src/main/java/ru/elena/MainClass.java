package ru.elena;

import java.util.Random;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        //      1. Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки угадать
        //это число. При каждой попытке компьютер должен сообщить, больше ли указанное пользователем число, чем
        // загаданное, или меньше. После победы или проигрыша выводится запрос – «Повторить игру еще раз?
        // 1 – да / 0 – нет»(1 – повторить, 0 – нет).

        Scanner sc = new Scanner(System.in);

        while (true) {
            //Запуск игры
            if(!play(sc)) {
                break;
            }

            //Вывести сообщение о продолжении/завершении игры.
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет» ");

            // Проверка введенного ответа
            if (!checkInt(sc)) {
                break;
            }

            //Получить ответ.
            int answer = sc.nextInt();

            //Проанализировать ответ
            if (answer != 1) {
                break;
            }
        }
    }

    public static boolean play(Scanner scanner) {
        //Загадать число
        Random random = new Random();
        int numberMemory = random.nextInt(10);

        //Предлагаю угадать число от 0 до 9.
        System.out.println("Угадайте число от 0 до 9");

        int input = 0;
        for (int i = 0; i < 3; i++) {
            // Проверка введенного ответа
            if (!checkInt(scanner)) {
                return false;
            }
            // Получить число с консоли.
            input = scanner.nextInt();

            //Проверка введенное число больше загаданного.
            if (input > numberMemory) {
                System.out.println("Введенное значение больше");
            }
            //Проверка введенное число меньше загаданного.
            else if (input < numberMemory) {
                System.out.println("Введенное значение меньше");
            }
            // Проверка введенное число равно загаданному.
            else if (input == numberMemory) {
                System.out.println("Число угадано!");

                //Остановка цикла.
                break;
            }

        }

        return true;
    }

    public static boolean checkInt(Scanner scanner) {
        boolean result = scanner.hasNextInt();

        if(!result) {
            System.out.println("Введен неверный символ");
        }

        return result;

    }
}
