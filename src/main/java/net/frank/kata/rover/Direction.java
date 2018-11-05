package net.frank.kata.rover;

public enum Direction {

    NORTH("\u25B3"),
    SOUTH("\u25BD"),
    EAST("\u25B7"),
    WEST("\u25BD");

    private final String mark;

    Direction(String mark) {
        this.mark = mark;
    }

    public String getMark() {
        return mark;
    }
}
