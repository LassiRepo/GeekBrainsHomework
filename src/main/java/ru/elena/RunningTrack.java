package ru.elena;

public class RunningTrack implements Obstacles {
    int length;
    public RunningTrack(int length){
        this.length = length;
    }
    @Override
    public boolean overcome(Competitors competitor) {
        return competitor.run(length);

    }
}
