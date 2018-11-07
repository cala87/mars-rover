package net.frank.kata.rover;

import net.frank.kata.rover.commands.IllegalCommandException;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class RoverTest {

    @Test
    public void emptySequenceCommandTest() throws IllegalCommandException {
        Rover rover = new Rover(1, 1, Direction.NORTH);

        rover.perform("");

        assertThat(rover)
                .isEqualTo(new Rover(1, 1, Direction.NORTH));
    }

    @Test(expected = IllegalCommandException.class)
    public void randomWrongSequenceCommandTest() throws IllegalCommandException {
        Rover rover = new Rover(1, 1, Direction.NORTH);

        rover.perform("abcdefghil");
    }
}
