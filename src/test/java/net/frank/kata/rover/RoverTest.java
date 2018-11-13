package net.frank.kata.rover;

import net.frank.kata.rover.commands.IllegalCommandException;
import net.frank.kata.rover.planets.ObstacleOnPathException;
import net.frank.kata.rover.planets.Planet;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;


public class RoverTest {

    private static PlanetMap map;

    @BeforeClass
    public static void init(){
        map = new PlanetMap(Planet.MARS, Collections.emptySet());
    }

    @Test
    public void emptySequenceCommandTest() throws IllegalCommandException, ObstacleOnPathException {
        Rover rover = new Rover(1, 1, Direction.NORTH, map);

        rover.perform("");

        assertThat(rover)
                .isEqualTo(new Rover(1, 1, Direction.NORTH, map));
    }

    @Test(expected = IllegalCommandException.class)
    public void randomWrongSequenceCommandTest() throws IllegalCommandException, ObstacleOnPathException {
        Rover rover = new Rover(1, 1, Direction.NORTH, map);

        rover.perform("abcdefghil");
    }

    @Test
    public void correctSequenceCommandTest() throws IllegalCommandException, ObstacleOnPathException {
        Rover rover = new Rover(1, 1, Direction.NORTH, map);

        rover.perform("fblrfflbb");

        assertThat(rover.getCoordinates()).isEqualTo(new Coordinates(3,3));
        assertThat(rover.getDirection()).isEqualTo(Direction.WEST);
    }

}
