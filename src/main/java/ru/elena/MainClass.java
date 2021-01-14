package ru.elena;

public class MainClass {
    public static void main(String[] args) {
        // Задание №2
        // Это тигр
        byte age = 15;
        short tailLength = 60;
        int clawsQty = 30;
        long dailyKkal = 5600L;
        float height = 1.07F;
        double price = 5345056.59;
        char gender = 'F';
        boolean resident = true;

        // Задание №3
        float z = 9.2F;
        float x = 56.20F;
        float m = -22F;
        float v = 633F;

        float result = calculate(z, x, m, v);
        System.out.println(result);

        // Задание №4
        int param1 = 90;
        int param2 = -66;

        System.out.println(check(param1, param2));

        // Задание №5
        int number = 50;
        checkNumber(number);

        // Задание №6
        int a = -10;
        checkValue(a);
        System.out.println(checkValue(a));

        // Задание №7
        String name = "Елена";
        printName(name);
    }

    public static  float calculate(float a, float b, float c, float d){
        float calculate = a * (b + (c / d));
        return calculate;
    }

    public static boolean check(int param1, int param2) {
        int summ = param1 + param2;
        if (summ >= 10 && summ <= 20) {
            return true;
        } else {
            return false;
        }
    }

    public static void checkNumber(int number) {
        if (number >= 0) {
            System.out.println("Number is positive");
        }
        else {
            System.out.println("Number is negative");
        }
    }

    public static boolean checkValue(int a) {
        if (a < 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void printName(String name){
        System.out.println("Привет, " + name + "!");
    }
}
