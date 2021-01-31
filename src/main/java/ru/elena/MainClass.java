package ru.elena;

public class MainClass {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Бобик");
        dog1.run(50);
        dog1.swim(50);
        Cat cat1 = new Cat("Барсик");
        cat1.run(200);
        cat1.swim(50);

        Cat cat2 = new Cat("Котэ");
        Cat cat3 = new Cat("Кошак");
        Cat cat4 = new Cat("Киса");

        Animal.getCreatedAnimalsCount();
        Dog.getCreatedDogCount();
        Cat.getCreatedCatCount();
    }
}
