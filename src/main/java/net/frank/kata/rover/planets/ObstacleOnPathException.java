package net.frank.kata.rover.planets;

import net.frank.kata.rover.Coordinates;

public class ObstacleOnPathException extends Exception {

    private final Coordinates coordinates;
    private final Coordinates nextCoordinates;

    public ObstacleOnPathException(Coordinates coordinates, Coordinates nextCoordinates) {
        this.coordinates = coordinates;
        this.nextCoordinates = nextCoordinates;
    }

    @Override
    public String getMessage() {
        return String.format("Obstacle at position %s! Last position reached %s", nextCoordinates, coordinates);
    }
}
