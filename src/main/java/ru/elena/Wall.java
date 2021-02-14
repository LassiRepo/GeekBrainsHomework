package ru.elena;

public class Wall implements Obstacles {
    int height;

    public Wall(int height){
    this.height = height;
    }
    @Override
    public boolean overcome(Competitors competitor) {
        return competitor.jump(height);

    }
}
