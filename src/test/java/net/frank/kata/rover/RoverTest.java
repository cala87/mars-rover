package net.frank.kata.rover;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class RoverTest {

    @Test
    public void emptySequenceCommandTest() {
        Rover rover = new Rover(1, 1, Direction.NORTH);

        rover.perform("");

        assertThat(rover)
                .isEqualTo(new Rover(1, 1, Direction.NORTH));
    }
}
