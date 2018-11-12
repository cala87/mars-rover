package net.frank.kata.rover.commands;

import net.frank.kata.rover.Rover;
import net.frank.kata.rover.common.Command;
import net.frank.kata.rover.common.To;
import net.frank.kata.rover.planets.ObstacleOnPathException;

public class MoveForward implements Command {

    @Override
    public void execute(Rover rover) throws ObstacleOnPathException {
        rover.move(To.FORWARD);
    }

}
