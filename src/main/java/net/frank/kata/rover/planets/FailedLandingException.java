package net.frank.kata.rover.planets;

public class FailedLandingException extends Exception {

    public FailedLandingException() {
    }

    public FailedLandingException(String message) {
        super(message);
    }

    public FailedLandingException(String message, Throwable cause) {
        super(message, cause);
    }

    public FailedLandingException(Throwable cause) {
        super(cause);
    }
}
