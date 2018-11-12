package net.frank.kata.rover;

import net.frank.kata.rover.planets.Planet;

public class Main {

    public static void main(String[] args) {

        PlanetMap map = new PlanetMap(Planet.MARS, 10);
        Rover rover = new Rover(0, 0, Direction.NORTH, map);
        
    }

}
