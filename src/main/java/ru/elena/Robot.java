package ru.elena;

public class Robot implements Competitors {
    String name;
    int maxDistance;
    int maxJumpHeight;

    public Robot(String name, int maxDistance, int maxJumpHeight) {
        this.name = name;
        this.maxDistance = maxDistance;
        this.maxJumpHeight = maxJumpHeight;
    }

    @Override
    public boolean run(int length) {
        if (maxDistance >= length){
            System.out.println("Робот " + name + " пробежал");
            return true;
        }else{
            System.out.println("Робот " + name + " не смог пробежать");
            return false;
        }
    }

    @Override
    public boolean jump(int height) {
        if (maxJumpHeight > height){
            System.out.println("Робот " + name + " перепрыгнул");
            return true;
        } else{
            System.out.println("Робот " + name + " не смог перепрыгнуть");
            return false;
        }
    }

    @Override
    public void printWin() {
        System.out.println("Робот " + name + " прошел все препятствия!");
    }
}
