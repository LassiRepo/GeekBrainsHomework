package ru.elena;

public class Cat extends Animal {

    private final int maxLetLengthRun = 200;

    private static int catCount;

    public Cat(String name) {
        super(name);
        catCount++;
    }

    @Override
    public void run(int letLengthRun) {
        if (letLengthRun <= 0) {
            System.out.println(name + "Стоит на месте");
        } else if (letLengthRun <= maxLetLengthRun) {
            System.out.println(name + " пробежал " + letLengthRun + " м.");
        } else {
            System.out.println("Кошка не может пробежать больше " + maxLetLengthRun + " м.");
        }
    }

    @Override
    public void swim(int letLengthSwim) {
        System.out.println("Кошки не умеют плавать");
    }

    public static void getCreatedCatCount() {
        System.out.println(("Всего создано " + catCount + " кошек"));

    }
}

