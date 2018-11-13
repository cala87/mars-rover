package net.frank.kata.rover;

import net.frank.kata.rover.commands.IllegalCommandException;
import net.frank.kata.rover.planets.ObstacleOnPathException;
import net.frank.kata.rover.planets.Planet;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class MapBoundsTest {

    private static PlanetMap map;

    @BeforeClass
    public static void init(){
        map = new PlanetMap(Planet.MARS, Collections.emptySet());
    }

    @Test
    public void correctSequenceCommandWithOutboundTest() throws IllegalCommandException, ObstacleOnPathException {
        Rover rover = new Rover(3, 3, Direction.WEST, map);

        rover.perform("rffrffbflffrfffrflff");

        assertThat(rover.getCoordinates()).isEqualTo(new Coordinates(0,6));
        assertThat(rover.getDirection()).isEqualTo(Direction.EAST);
    }

    @Test
    public void topRightEastOutboundTest() throws IllegalCommandException, ObstacleOnPathException {
        Rover rover = new Rover(9, 9, Direction.WEST, map);

        rover.perform("rrf");

        assertThat(rover.getCoordinates()).isEqualTo(new Coordinates(0,9));
        assertThat(rover.getDirection()).isEqualTo(Direction.EAST);
    }

    @Test
    public void topRightNorthOutboundTest() throws IllegalCommandException, ObstacleOnPathException {
        Rover rover = new Rover(9, 9, Direction.NORTH, map);

        rover.perform("f");

        assertThat(rover.getCoordinates()).isEqualTo(new Coordinates(9,0));
        assertThat(rover.getDirection()).isEqualTo(Direction.NORTH);
    }

    @Test
    public void bottomRightEastOutboundTest() throws IllegalCommandException, ObstacleOnPathException {
        Rover rover = new Rover(9, 0, Direction.NORTH, map);

        rover.perform("rf");

        assertThat(rover.getCoordinates()).isEqualTo(new Coordinates(0,0));
        assertThat(rover.getDirection()).isEqualTo(Direction.EAST);
    }

    @Test
    public void bottomRightSouthOutboundTest() throws IllegalCommandException, ObstacleOnPathException {
        Rover rover = new Rover(9, 0, Direction.NORTH, map);

        rover.perform("b");

        assertThat(rover.getCoordinates()).isEqualTo(new Coordinates(9,9));
        assertThat(rover.getDirection()).isEqualTo(Direction.NORTH);
    }

    @Test
    public void bottomLeftWestOutboundTest() throws IllegalCommandException, ObstacleOnPathException {
        Rover rover = new Rover(0, 0, Direction.NORTH, map);

        rover.perform("lf");

        assertThat(rover.getCoordinates()).isEqualTo(new Coordinates(9,0));
        assertThat(rover.getDirection()).isEqualTo(Direction.WEST);
    }

    @Test
    public void bottomLeftSouthOutboundTest() throws IllegalCommandException, ObstacleOnPathException {
        Rover rover = new Rover(0, 0, Direction.NORTH, map);

        rover.perform("b");

        assertThat(rover.getCoordinates()).isEqualTo(new Coordinates(0,9));
        assertThat(rover.getDirection()).isEqualTo(Direction.NORTH);
    }

    @Test
    public void topLeftWestOutboundTest() throws IllegalCommandException, ObstacleOnPathException {
        Rover rover = new Rover(0, 9, Direction.WEST, map);

        rover.perform("f");

        assertThat(rover.getCoordinates()).isEqualTo(new Coordinates(9,9));
        assertThat(rover.getDirection()).isEqualTo(Direction.WEST);
    }

    @Test
    public void topLeftNorthOutboundTest() throws IllegalCommandException, ObstacleOnPathException {
        Rover rover = new Rover(0, 9, Direction.NORTH, map);

        rover.perform("f");

        assertThat(rover.getCoordinates()).isEqualTo(new Coordinates(0,0));
        assertThat(rover.getDirection()).isEqualTo(Direction.NORTH);
    }

}
