package net.frank.kata.rover;

import lombok.EqualsAndHashCode;
import net.frank.kata.rover.common.To;

@EqualsAndHashCode
public class Rover {

    private Coordinates coordinates;
    private Coordinates nextCoordinates;
    private Direction direction;

    public Rover(int x, int y, Direction direction) {
        this.coordinates = new Coordinates(x, y);
        this.direction = direction;
    }

    public void perform(String commands) {

    }

    public void turn(To to) {

    }

    public void move() {

    }

    boolean checkNextCoordinates() {
        return false;
    }

}
