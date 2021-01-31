package ru.elena;

public class Dog extends Animal {

    private final int maxletLengthRunDog = 500;

    private final int maxLetLengthSwim = 10;

    private static int dogCount;

    public Dog(String name) {
        super(name);
        dogCount++;
    }

    @Override
    public void run(int letLengthRun) {
        if (letLengthRun <= 0) {
            System.out.println(name + " стоит на месте");
        } else if (letLengthRun <= maxletLengthRunDog) {
            System.out.println(name + " пробежал " + letLengthRun + " м.");
        } else {
            System.out.println("Собака не может пробежать больше " + maxletLengthRunDog + " м.");
        }
    }

    @Override
    public void swim(int letLengthSwim) {
        if (letLengthSwim <= maxLetLengthSwim) {
            System.out.println(name + " проплыл " + letLengthSwim + " м.");

        } else {
            System.out.println("Собака не может проплыть больше " + maxLetLengthSwim + " м.");
        }

    }

    public static void getCreatedDogCount() {
        System.out.println("Всего создано " + dogCount + " собак");
    }
}
