package ru.elena;

public abstract class Animal {
    protected String name;
    private static int animalCount;

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public abstract void run(int letLengthRun);

    public abstract void swim(int letLengthSwim);

    public static void getCreatedAnimalsCount() {
        System.out.println("Всего создано " + animalCount + " животных");
    }

}
