package ru.elena;

public class MainClass {
    public static void main(String[] args) {
        Plate plate = new Plate();
        plate.addFood(160);

        Cat[] cats = {
                new Cat("Barsik", 5),
                new Cat("Murzik", 10),
                new Cat("Yason",11),
                new Cat("Kisa", 16),
                new Cat("Kotya",8),
                new Cat("Gosha", 19),
                new Cat("Tosha",9),
                new Cat("Marik",10),
                new Cat("Saturn", 12),
                new Cat("Kris",13),
                new Cat("On", 9)
        };
        for (int i = 0; i < cats.length ; i++) {
            cats[i].eat(plate);
            cats[i].printNotHungry();
        }
        plate.getFoodQuantity();
    }
}
