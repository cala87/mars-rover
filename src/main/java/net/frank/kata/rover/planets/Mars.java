package net.frank.kata.rover.planets;

import net.frank.kata.rover.Coordinates;
import net.frank.kata.rover.Direction;

import java.util.Random;
import java.util.stream.IntStream;

public class Mars {

    public static final int SIZE = 10;
    public static final int TOT_OBSTACLES = 5;
    public static final String OBSTACLE = "O";

    private final String[][] map;
    private int filled;

    public Mars() {
        this.map = new String[Mars.SIZE][Mars.SIZE];
    }

    public void fillObstacles() {
        if (filled == Mars.TOT_OBSTACLES) return;
        while (filled < Mars.TOT_OBSTACLES) {
            int x = randomCoordinate();
            int y = randomCoordinate();
            if (map[x][y] == null) {
                map[x][y] = Mars.OBSTACLE;
                filled++;
            }
        }
    }

    public String getMap(Coordinates actualCoordinates, Direction direction) {
        StringBuilder printedMap = new StringBuilder();

        IntStream.range(0, 4 * SIZE + 1).forEach(i -> {
            printedMap.append("-");
        });
        printedMap.append("\n");

        for (int x = 0; x < Mars.SIZE; x++) {
            printedMap.append("|");
            for (int y = 0; y < Mars.SIZE; y++) {
                printedMap.append(" ");
                if (x == actualCoordinates.getX()
                        && y == actualCoordinates.getY()) {
                    printedMap.append(direction.getMark());
                } else {
                    String value = map[x][y];
                    printedMap.append(value == null ? " " : value);
                }
                printedMap.append(" |");
            }
            printedMap.append("\n");
            IntStream.range(0, 4 * SIZE + 1).forEach(i -> {
                printedMap.append("-");
            });
            printedMap.append("\n");
        }

        return printedMap.toString();
    }

    private static int randomCoordinate() {
        return new Random().nextInt(Mars.SIZE - 1);
    }
}
