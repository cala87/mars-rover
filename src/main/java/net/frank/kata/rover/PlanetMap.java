package net.frank.kata.rover;

import net.frank.kata.rover.planets.FailedLandingException;
import net.frank.kata.rover.planets.Planet;

import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;

public class PlanetMap {

    private static final String OBSTACLE = "O";

    private final Planet planet;
    private final int numObstacles;

    private final Coordinates bottomBorder = new Coordinates(0, 0);
    private final Coordinates topBorder;

    private Set<Coordinates> obstacles = Collections.emptySet();

    public PlanetMap(Planet planet, int numObstacles) {
        this.planet = planet;
        this.numObstacles = numObstacles;
        topBorder = new Coordinates(planet.getSize() - 1, planet.getSize() - 1);
    }

    public PlanetMap(Planet planet, Set<Coordinates> obstacles) {
        this(planet, obstacles.size());
        this.obstacles = obstacles;
    }

    public void init(Coordinates coordinates) throws FailedLandingException {
        if (obstacles.isEmpty()) {
            obstacles = generateObstacles(numObstacles);
        }

        if (hasObstacle(coordinates))
            throw new FailedLandingException(String.format("Landing at coordinates x : %d - y : %d", coordinates.getX(), coordinates.getY()));
    }

    boolean hasObstacle(Coordinates coordinates) {
        return obstacles.contains(coordinates);
    }

    public String render(Coordinates actualCoordinates, Direction direction) {
        StringBuilder printedMap = new StringBuilder("  ");

        IntStream.range(0, 4 * planet.getSize() + 1).forEach(i -> {
            printedMap.append("-");
        });
        printedMap.append("\n");

        for (int y = planet.getSize() - 1; y >= 0; y--) {
            printedMap.append(y).append(" |");
            for (int x = 0; x < planet.getSize(); x++) {
                Coordinates renderCoordinates = new Coordinates(x, y);
                printedMap.append(" ");
                if (renderCoordinates.equals(actualCoordinates)) {
                    printedMap.append(direction.getMark());
                } else {
                    if (hasObstacle(renderCoordinates))
                        printedMap.append(OBSTACLE);
                    else
                        printedMap.append(" ");
                }
                printedMap.append(" |");
            }
            printedMap.append("\n  ");
            IntStream.range(0, 4 * planet.getSize() + 1).forEach(i -> {
                printedMap.append("-");
            });
            printedMap.append("\n");
        }
        printedMap.append("  ");
        IntStream.range(0, planet.getSize()).forEach(i -> {
            printedMap.append("  ").append(i).append(" ");
        });

        return printedMap.toString();
    }

    protected Set<Coordinates> generateObstacles(int numObstacles) {
        int size = planet.getSize();
        if (numObstacles >= size * size) {
            throw new IllegalArgumentException(String.format("Too many obstacles for %s : %d obs. against %d pos.", planet.getName(), numObstacles, size * size));
        }

        Set<Coordinates> obstacles = new HashSet<>();
        int filledObstacles = 0;
        while (filledObstacles < numObstacles) {
            int x = randomCoordinate();
            int y = randomCoordinate();

            Coordinates possibleObstacle = new Coordinates(x, y);
            if (!obstacles.contains(possibleObstacle)) {
                obstacles.add(possibleObstacle);
                filledObstacles++;
            }
        }

        return obstacles;
    }

    private int randomCoordinate() {
        return new Random().nextInt(planet.getSize() - 1);
    }


    public Coordinates checkCoordinates(Coordinates coordinates) {
        int x = coordinates.getX();
        int y = coordinates.getY();

        if (x > topBorder.getX()) x -= bottomBorder.getX();
        if (x < bottomBorder.getX()) x += bottomBorder.getX();

        if (y > topBorder.getY()) x -= bottomBorder.getY();
        if (y < bottomBorder.getY()) x += bottomBorder.getY();

        return new Coordinates(x, y);
    }
}
