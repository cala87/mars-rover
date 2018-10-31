package net.frank.kata.rover.common;

import net.frank.kata.rover.Rover;

public interface Command {

    void execute(Rover rover);
}
