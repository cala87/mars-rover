package net.frank.kata.rover.planets;

public class ObstacleOnPathException extends Exception {
    public ObstacleOnPathException() {
        super();
    }

    public ObstacleOnPathException(String message) {
        super(message);
    }

    public ObstacleOnPathException(String message, Throwable cause) {
        super(message, cause);
    }

    public ObstacleOnPathException(Throwable cause) {
        super(cause);
    }
}
