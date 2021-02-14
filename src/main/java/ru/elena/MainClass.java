package ru.elena;

public class MainClass {
    public static void main(String[] args) {

        Competitors[] competitors = {
                new Human("Garry", 80, 180),
                new Human("Mark", 100, 140),
                new Cat("Barsik", 110, 200),
                new Cat("Murzik", 140, 170),
                new Robot("RK206", 1000, 60),
                new Robot("T-1000", 2000, 100)
        };

        Obstacles[] obstacles = {
                new RunningTrack(60),
                new Wall(65),
                new RunningTrack(100),
                new Wall(100),
                new RunningTrack(30),
                new Wall(150),
                new RunningTrack(120)
        };

        for (int i = 0; i < competitors.length; i++) {
            boolean allDone = true;

            for (int j = 0; j < obstacles.length; j++) {
                if (!obstacles[j].overcome(competitors[i])){
                    allDone = false;
                    break;
                }
            }

            if(allDone) {
                competitors[i].printWin();
            }
        }
    }
}
