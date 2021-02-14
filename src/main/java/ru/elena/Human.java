package ru.elena;

public class Human implements Competitors {
    String name;
    int maxDistance;
    int maxJumpHeight;

    public Human(String name, int maxDistance, int maxJumpHeight) {
        this.name = name;
        this.maxDistance = maxDistance;
        this.maxJumpHeight = maxJumpHeight;
    }

    @Override
    public boolean run(int length) {
        if (maxDistance >= length){
            System.out.println("Человек " + name + " пробежал");
            return true;
        }else{
            System.out.println("Человек " + name + " не смог пробежать");
            return false;
        }
    }

    @Override
    public boolean jump(int height) {
        if (maxJumpHeight > height){
            System.out.println("Человек " + name + " перепрыгнул");
            return true;
        } else{
            System.out.println("Человек " + name + " не смог перепрыгнуть");
            return false;
        }
    }

    @Override
    public void printWin() {
        System.out.println("Человек " + name + " прошел все препятствия!");
    }
}
