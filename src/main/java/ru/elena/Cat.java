package ru.elena;

public class Cat {

    private String name;

    private int appetite;

    private boolean notHungry;

    public Cat(String name, int appetite){
        this.name = name;
        this.appetite = appetite;
        this.notHungry = false;
    }

    public void eat(Plate plate){
        if (plate.decreaseFood(appetite) == true){
            notHungry = true;
        }
    }
    public void printNotHungry() {
        if (notHungry == false) {
            System.out.println(name + " голодный");
        } else {
            System.out.println(name + " поел");
        }
    }
}
