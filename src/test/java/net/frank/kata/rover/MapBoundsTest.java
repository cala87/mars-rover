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
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class MapBoundsTest {

    private static PlanetMap map;

    @BeforeClass
    public static void init() {
        map = new PlanetMap(Planet.MARS, Collections.emptySet());
    }

    private Coordinates initialCoordinates;
    private Direction initialDirection;
    private String commands;
    private Coordinates expectedCoordinates;
    private Direction expectedDirection;

    public MapBoundsTest(Coordinates initialCoordinates,
                         Direction initialDirection,
                         String commands,
                         Coordinates expectedCoordinates,
                         Direction expectedDirection) {
        this.initialCoordinates = initialCoordinates;
        this.initialDirection = initialDirection;
        this.commands = commands;
        this.expectedCoordinates = expectedCoordinates;
        this.expectedDirection = expectedDirection;

    }

    @Parameters(name = "{index} -> {0}, {1}, {2}, {3}, {4}")
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][]{
                {new Coordinates(3, 3), Direction.WEST, "rffrffbflffrfffrflff", new Coordinates(0, 6), Direction.EAST},
                {new Coordinates(9, 9), Direction.WEST, "rrf", new Coordinates(0, 9), Direction.EAST},
                {new Coordinates(9, 9), Direction.NORTH, "f", new Coordinates(9, 0), Direction.NORTH},
                {new Coordinates(9, 0), Direction.NORTH, "rf", new Coordinates(0, 0), Direction.EAST},
                {new Coordinates(9, 0), Direction.NORTH, "b", new Coordinates(9, 9), Direction.NORTH},
                {new Coordinates(0, 0), Direction.NORTH, "lf", new Coordinates(9, 0), Direction.WEST},
                {new Coordinates(0, 0), Direction.NORTH, "b", new Coordinates(0, 9), Direction.NORTH},
                {new Coordinates(0, 9), Direction.WEST, "f", new Coordinates(9, 9), Direction.WEST},
                {new Coordinates(0, 9), Direction.NORTH, "f", new Coordinates(0, 0), Direction.NORTH}
        });
    }

    @Test
    public void correctSequenceCommandWithOutboundTest() throws IllegalCommandException, ObstacleOnPathException, FailedLandingException {
        Rover rover = new Rover(initialCoordinates, initialDirection, map);
        rover.perform(commands);

        assertThat(rover.getCoordinates()).isEqualTo(expectedCoordinates);
        assertThat(rover.getDirection()).isEqualTo(expectedDirection);
    }

}
