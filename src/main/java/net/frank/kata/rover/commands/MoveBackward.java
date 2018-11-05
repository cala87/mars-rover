package net.frank.kata.rover.commands;

import net.frank.kata.rover.Rover;
import net.frank.kata.rover.common.Command;
import net.frank.kata.rover.common.To;

public class MoveBackward implements Command {

    @Override
    public void execute(Rover rover) {
        rover.move(To.BACKWARD);
    }

}
