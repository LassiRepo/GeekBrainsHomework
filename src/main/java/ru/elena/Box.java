package ru.elena;

import ru.elena.fruits.Fruit;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {

    private final List<T> fruitList = new ArrayList<>();

    public Float getWeight() {
        if (fruitList.size() != 0) {
            return fruitList.size() * fruitList.get(0).getWeight();
        } else {
            return 0f;
        }
    }

    public boolean compare(Box box) {
        return box.getWeight().equals(getWeight());
    }

    public void unionBoxes(Box<T> box) {
        fruitList.addAll(box.fruitList);
        box.fruitList.clear();
    }

    public void addFruit(T fruit) {
        fruitList.add(fruit);
    }
}


