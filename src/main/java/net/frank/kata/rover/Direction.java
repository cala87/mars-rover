package net.frank.kata.rover;

public enum Direction {

    NORTH(0, 1, "WEST", "EAST", "\u25B3"),
    SOUTH(0, -1, "EAST", "WEST", "\u25BD"),
    EAST(1, 0, "NORTH", "SOUTH", "\u25B7"),
    WEST(-1, 0, "SOUTH", "NORTH", "\u25BD");

    private final int xHop;
    private final int yHop;
    private final String left;
    private final String right;
    private final String mark;

    Direction(int xHop, int yHop, String left, String right, String mark) {
        this.xHop = xHop;
        this.yHop = yHop;
        this.left = left;
        this.right = right;
        this.mark = mark;
    }

    public int getXHop() {
        return xHop;
    }

    public int getYHop() {
        return yHop;
    }

    public Direction getLeft() {
        return valueOf(left);
    }

    public Direction getRight() {
        return valueOf(right);
    }

    public String getMark() {
        return mark;
    }
}
