package net.frank.kata.rover;

import lombok.Value;

@Value
public class Coordinates {

    private final int x;
    private final int y;

    public Coordinates(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

}
