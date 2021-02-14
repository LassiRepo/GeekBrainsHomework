package ru.elena;

public class Cat implements Competitors {
    String name;
    int maxDistance;
    int maxJumpHeight;

    public Cat(String name, int maxDistance, int maxJumpHeight){
        this.name = name;
        this.maxDistance = maxDistance;
        this.maxJumpHeight = maxJumpHeight;
    }

    @Override
    public boolean run(int length) {
        if (maxDistance >= length){
            System.out.println("Кот " + name + " пробежал");
            return true;
        }else{
            System.out.println("Кот " + name + " не смог пробежать");
            return false;
        }
    }

    @Override
    public boolean jump(int height) {
        if (maxJumpHeight > height){
            System.out.println("Кот " + name + " перепрыгнул");
            return true;
        } else{
            System.out.println("Кот " + name + " не смог перепрыгнуть");
            return false;
        }
    }

    @Override
    public void printWin() {
        System.out.println("Кот " + name + " прошел все препятствия!");
    }
}
