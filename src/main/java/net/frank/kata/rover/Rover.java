package net.frank.kata.rover;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import net.frank.kata.rover.commands.*;
import net.frank.kata.rover.common.Command;
import net.frank.kata.rover.common.To;

import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@EqualsAndHashCode
public class Rover {

    private Coordinates coordinates;
    private Coordinates nextCoordinates;
    private Direction direction;


    public Rover(int x, int y, Direction direction) {
        this.coordinates = new Coordinates(x, y);
        this.direction = direction;
    }

    public void perform(String commandMsg) throws IllegalCommandException {
        CommandParser parser = new CommandParser(commandMsg);
        List<Command> commands = parser.parse();

        for (Command command : commands) {
            command.execute(this);
        }

    }

    public void turn(To to) {

    }

    public void move(To to) {

    }

    boolean checkNextCoordinates() {
        return false;
    }

    class CommandParser {

        String commandsString;

        private Map<To, Command> commandMap = new EnumMap<To, Command>(To.class) {
            {
                commandMap.put(To.FORWARD, new MoveForward());
                commandMap.put(To.BACKWARD, new MoveBackward());
                commandMap.put(To.LEFT, new RotateLeft());
                commandMap.put(To.RIGHT, new RotateRight());
            }
        };

        public CommandParser(@NonNull String commandsString) {
            this.commandsString = commandsString;
        }

        List<Command> parse() throws IllegalCommandException {
            char[] charCommands = commandsString.toCharArray();

            List<Command> commandList = new LinkedList<>();
            for (char command : charCommands) {
                if (!To.commands().contains(command))
                    throw new IllegalCommandException(String.format("Error! Command '%s' not implemented", command));

                commandList.add(commandMap.get(To.fromCharCommand(command)));
            }

            return commandList;
        }


    }

}
