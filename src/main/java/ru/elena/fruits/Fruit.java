package ru.elena.fruits;

public abstract class Fruit {
    private final Float weight;

    protected Fruit(Float weight) {
        this.weight = weight;
    }

    public Float getWeight() {
        return weight;
    }
}