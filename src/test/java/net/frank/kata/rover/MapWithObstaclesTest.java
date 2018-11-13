package net.frank.kata.rover;

import net.frank.kata.rover.commands.IllegalCommandException;
import net.frank.kata.rover.planets.FailedLandingException;
import net.frank.kata.rover.planets.ObstacleOnPathException;
import net.frank.kata.rover.planets.Planet;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@RunWith(Parameterized.class)
public class MapWithObstaclesTest {

    private static PlanetMap map;
    private static Set<Coordinates> obstacles;

    @BeforeClass
    public static void init() {

        obstacles = new HashSet<>(Arrays.asList(
                new Coordinates(2, 3),
                new Coordinates(4, 5),
                new Coordinates(4, 6),
                new Coordinates(9, 1),
                new Coordinates(8, 2),
                new Coordinates(3, 7),
                new Coordinates(1, 2)
        ));

        map = new PlanetMap(Planet.MARS, obstacles);
    }

    private Coordinates initialCoordinates;
    private Direction initialDirection;
    private String commands;
    private Coordinates expectedCoordinates;
    private Direction expectedDirection;
    private boolean exception;

    public MapWithObstaclesTest(Coordinates initialCoordinates,
                                Direction initialDirection,
                                String commands,
                                Coordinates expectedCoordinates,
                                Direction expectedDirection,
                                boolean exception) {
        this.initialCoordinates = initialCoordinates;
        this.initialDirection = initialDirection;
        this.commands = commands;
        this.expectedCoordinates = expectedCoordinates;
        this.expectedDirection = expectedDirection;
        this.exception = exception;
    }

    /*
     * Test case Map
     *    -----------------------------------------
     *  9 |   |   |   |   |   |   |   |   |   |   |
     *    -----------------------------------------
     *  8 |   |   |   |   |   |   |   |   |   |   |
     *    -----------------------------------------
     *  7 |   |   |   | O |   |   |   |   |   |   |
     *    -----------------------------------------
     *  6 |   |   |   |   | O |   |   |   |   |   |
     *    -----------------------------------------
     *  5 |   |   |   |   | O |   |   |   |   |   |
     *    -----------------------------------------
     *  4 |   |   |   |   |   |   |   |   |   |   |
     *    -----------------------------------------
     *  3 |   |   | O |   |   |   |   |   |   |   |
     *    -----------------------------------------
     *  2 |   | O |   |   |   |   |   |   | O |   |
     *    -----------------------------------------
     *  1 |   |   |   |   |   |   |   |   |   | O |
     *    -----------------------------------------
     *  0 |   |   |   |   |   |   |   |   |   |   |
     *    -----------------------------------------
     *      0   1   2   3   4   5   6   7   8   9
     * */

    @Parameters(name = "{index} -> {0}, {1}, {2}, {3}, {4}, {5}")
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][]{
                {new Coordinates(0, 0), Direction.WEST, "ffrflfrffrffrf", new Coordinates(9, 2), Direction.SOUTH, false},
                {new Coordinates(5, 2), Direction.NORTH, "rfflffffffffrfbflf", new Coordinates(8, 1), Direction.NORTH, false},
                {new Coordinates(1, 6), Direction.NORTH, "bbbb", new Coordinates(1, 3), Direction.NORTH, true},
                {new Coordinates(9, 0), Direction.NORTH, "rf", new Coordinates(0, 0), Direction.EAST, false},
        });
    }

    @Test
    public void performCommandWithObstaclesTest() throws IllegalCommandException, ObstacleOnPathException, FailedLandingException {
        Rover rover = new Rover(initialCoordinates, initialDirection, map);
        if (exception)
            assertThatExceptionOfType(ObstacleOnPathException.class).isThrownBy(() -> {
                rover.perform(commands);
            });
        else
            rover.perform(commands);

        assertThat(rover.getCoordinates()).isEqualTo(expectedCoordinates);
        assertThat(rover.getDirection()).isEqualTo(expectedDirection);
    }


}
