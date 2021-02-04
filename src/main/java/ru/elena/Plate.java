package ru.elena;

public class Plate {
    private int food;
    private int additiveFood;

    public boolean decreaseFood(int foodToEat){
        if (food - foodToEat >= 0) {
            food -= foodToEat;
            return true;
        }else {
            System.out.println("Еды недостаточно");
            return false;
        }
    }
    public void addFood(int additiveFood){
        food = food + additiveFood;
    }
    public void getFoodQuantity(){
        System.out.println("plate:" + food);
    }

}
