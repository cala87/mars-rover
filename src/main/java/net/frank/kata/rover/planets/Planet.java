package net.frank.kata.rover.planets;

public enum Planet {

    MARS("Mars", 10);

    private final String name;
    private final int size;

    Planet(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }
}
