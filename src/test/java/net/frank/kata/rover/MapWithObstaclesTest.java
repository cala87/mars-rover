package net.frank.kata.rover;

import net.frank.kata.rover.planets.FailedLandingException;
import net.frank.kata.rover.planets.Planet;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MapWithObstaclesTest {

    private static PlanetMap map;
    private static Set<Coordinates> obstacles;

    private Rover rover;

    @BeforeClass
    public static void init(){

        obstacles = new HashSet<>(Arrays.asList(
                new Coordinates(2,3),
                new Coordinates(4,5),
                new Coordinates(4,6),
                new Coordinates(9,1),
                new Coordinates(8,2),
                new Coordinates(3, 7),
                new Coordinates(1,2)
        ));

        map = new PlanetMap(Planet.MARS, obstacles);
    }

    @Before
    public void initSingleTest() throws FailedLandingException {
        rover = new Rover(1,1, Direction.NORTH, map);
        rover.performLanding();
    }

    @Test(expected = FailedLandingException.class)
    public void failedLandingTest() throws FailedLandingException {
        Rover failedRover = new Rover(8,2, Direction.NORTH, map);
        failedRover.performLanding();
    }
}
