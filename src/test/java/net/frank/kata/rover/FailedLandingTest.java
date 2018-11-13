package net.frank.kata.rover;

import net.frank.kata.rover.commands.IllegalCommandException;
import net.frank.kata.rover.planets.FailedLandingException;
import net.frank.kata.rover.planets.ObstacleOnPathException;
import net.frank.kata.rover.planets.Planet;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

public class FailedLandingTest {

    private static PlanetMap map;

    @BeforeClass
    public static void init() {

        map = new PlanetMap(Planet.MARS, new HashSet<>(Arrays.asList(
                new Coordinates(8, 2)
        )));
    }

    @Test(expected = FailedLandingException.class)
    public void failedLandingTest() throws FailedLandingException, IllegalCommandException, ObstacleOnPathException {
        Rover failedRover = new Rover(8, 2, Direction.NORTH, map);
        failedRover.perform("fff");
    }

}
