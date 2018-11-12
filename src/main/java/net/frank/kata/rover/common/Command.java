package net.frank.kata.rover.common;

import net.frank.kata.rover.Rover;
import net.frank.kata.rover.planets.ObstacleOnPathException;

public interface Command {

    void execute(Rover rover) throws ObstacleOnPathException;
}
