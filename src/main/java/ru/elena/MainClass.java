package ru.elena;

import java.util.Random;
import java.util.Scanner;

public class MainClass {


    private static char[][] gameMap;
    public static Scanner sc = new Scanner(System.in);
    private static final int DOTS_TO_WIN = 3;
    private static final char EMPTY_DOT = '*';
    private static final char X_DOT = 'X';
    private static final char O_DOT = 'O';

    private static final int gameMapHeight = 3;
    private static final int gameMapWidth = 3;

    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {
        initGameMap(gameMapHeight, gameMapWidth);
        paintGameMap();
        int count = 0;
        while (true) {
            humanTurn();
            count++;
            paintGameMap();
            if (checkWin(X_DOT)) {
                System.out.println("You WIN!!!");
                break;
            }
            if (count == gameMap.length * gameMap[0].length) {
                System.out.println("FRIENDLY WIN -)))");
                break;
            }

            computerTurn();
            count++;
            paintGameMap();
            if (checkWin(O_DOT)) {
                System.out.println("Sorry, but you looser, computer WIN");
            }
            if (count == gameMap.length * gameMap[0].length) {
                System.out.println("FRIENDLY WIN -)))");
                break;
            }
        }
    }

    //Ход компьютера
    private static void computerTurn() {
        System.out.println("Computer not a human, computer thinking");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }

        int coordinates[] = new int[2];
        if(checkSymbolsForWin(coordinates)) {
            gameMap[coordinates[0]][coordinates[1]] = O_DOT;
        }
        else if (checkGamerSymbols(coordinates)) {
            gameMap[coordinates[0]][coordinates[1]] = O_DOT;
        } else {
            int x, y;
            boolean checkCell;
            Random random = new Random();
            do {
                x = random.nextInt(gameMapHeight);
                y = random.nextInt(gameMapWidth);
                checkCell = isValidCell(x, y);
            } while (!checkCell);
            gameMap[x][y] = O_DOT;
        }
    }

    //Ход человека
    private static void humanTurn() {
        int x = -1;
        int y = -1;
        boolean checkCell;
        do {
            System.out.println("Пожалуйста, введите координаты в формате X Y");
            if (sc.hasNextInt()) {
                x = sc.nextInt() - 1;
            }
            if (sc.hasNextInt()) {
                y = sc.nextInt() - 1;
            }
            checkCell = isValidCell(x, y);
            sc.nextLine();

        } while (!checkCell);
        gameMap[x][y] = X_DOT;
    }

    //Проверка на ноль и выход за границу массива для человека
    private static boolean isValidCell(int x, int y) {
        if (x < 0 || y < 0 || x > gameMapHeight || y > gameMapWidth) {
            return false;
        }
        return gameMap[x][y] == EMPTY_DOT;
    }

    //Печать поля на консоль
    private static void paintGameMap() {
        for (int i = 0; i < gameMapHeight; i++) {
            for (int j = 0; j < gameMapWidth; j++) {
                System.out.print(gameMap[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    //Заполняем поле точками
    private static void initGameMap(int height, int width) {
        gameMap = new char[height][width];
        for (int i = 0; i < gameMapHeight; i++) {
            for (int j = 0; j < gameMapWidth; j++) {
                gameMap[i][j] = EMPTY_DOT;
            }

        }
    }

    private static boolean checkWin(char gamerSymbol) {
        return checkHorizontals(gamerSymbol, null, false)
                || checkColumns(gamerSymbol, null, false)
                || checkDiagonals(gamerSymbol, null, false);
    }

    private static boolean checkGamerSymbols(int[] coordinates) {
        return checkHorizontals(X_DOT, coordinates, true)
                || checkColumns(X_DOT, coordinates, true)
                || checkDiagonals(X_DOT, coordinates, true);
    }

    private static boolean checkSymbolsForWin(int[] coordinates) {
        return checkHorizontals(X_DOT, coordinates, false)
                || checkColumns(X_DOT, coordinates, false)
                || checkDiagonals(X_DOT, coordinates, false);
    }

    private static boolean checkHorizontals(char gamerSymbol, int[] coordinates, boolean reduceQty) {
        int foundedSymbolsQty = 0;
        int requiredSymbolsQty = DOTS_TO_WIN;

        if (reduceQty) {
            requiredSymbolsQty--;
        }

        for (int i = 0; i < gameMap.length; i++) {
            for (int j = 0; j < gameMap.length; j++) {
                if (gameMap[i][j] == gamerSymbol) {
                    foundedSymbolsQty++;
                } else if (coordinates != null) {
                    if (gameMap[i][j] == EMPTY_DOT) {
                        coordinates[0] = i;
                        coordinates[1] = j;
                    } else {
                        foundedSymbolsQty--;
                    }
                }
            }

            if (foundedSymbolsQty == requiredSymbolsQty) {
                return true;
            } else {
                foundedSymbolsQty = 0;
            }
        }

        return false;
    }

    private static boolean checkColumns(char gamerSymbol, int[] coordinates, boolean reduceQty) {
        int index = 0;
        int foundedSymbolsQty = 0;
        int requiredSymbolsQty = DOTS_TO_WIN;

        if (reduceQty) {
            requiredSymbolsQty = requiredSymbolsQty - 1;
        }

        while (index < gameMapWidth) {
            for (int i = 0; i < gameMapHeight; ++i) {
                if (gameMap[i][index] == gamerSymbol) {
                    foundedSymbolsQty++;
                } else if (coordinates != null) {
                    if (gameMap[i][index] == EMPTY_DOT) {
                        coordinates[0] = i;
                        coordinates[1] = index;
                    } else {
                        foundedSymbolsQty--;
                    }
                }
            }

            if (foundedSymbolsQty == requiredSymbolsQty) {
                return true;
            }

            index++;
            foundedSymbolsQty = 0;
        }

        return false;
    }

    private static boolean checkDiagonals(char gamerSymbol, int[] coordinates, boolean reduceQty) {
        int countSymbolsInLeftDiagonal = 0;
        int countSymbolsInRightDiagonal = 0;
        int requiredSymbolsQty = DOTS_TO_WIN;
        int cellsCheckedLeft = 0;

        if (reduceQty) {
            requiredSymbolsQty = requiredSymbolsQty - 1;
        }

        for (int i = 0; i < gameMapHeight; i++) {
            for (int j = 0; j < gameMapWidth; j++) {
                if (i == j) {
                    if (gameMap[i][j] == gamerSymbol) {
                        countSymbolsInLeftDiagonal++;
                    } else if (coordinates != null) {
                        if (gameMap[i][j] == EMPTY_DOT) {
                            coordinates[0] = i;
                            coordinates[1] = j;
                        } else {
                            countSymbolsInLeftDiagonal--;
                        }
                    }

                    cellsCheckedLeft++;
                }

                if (cellsCheckedLeft == DOTS_TO_WIN && countSymbolsInLeftDiagonal == requiredSymbolsQty) {
                    return true;
                }
            }
        }

        for (int i = 0, j = gameMapHeight -1; i < gameMapHeight; i++, j--) {
            if (gameMap[i][j] == gamerSymbol) {
                countSymbolsInRightDiagonal++;
            } else if (coordinates != null) {
                if (gameMap[i][j] == EMPTY_DOT) {
                    coordinates[0] = i;
                    coordinates[1] = j;
                } else {
                    countSymbolsInRightDiagonal--;
                }
            }
        }

        if (countSymbolsInRightDiagonal == requiredSymbolsQty) {
            return true;
        }

        return false;
    }
}
