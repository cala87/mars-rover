package net.frank.kata.rover;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import net.frank.kata.rover.commands.*;
import net.frank.kata.rover.common.Command;
import net.frank.kata.rover.common.To;
import net.frank.kata.rover.planets.ObstacleOnPathException;

import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Slf4j
@EqualsAndHashCode
public class Rover {

    @Getter
    private Coordinates coordinates;
    private Coordinates nextCoordinates;
    @Getter
    private Direction direction;

    private final PlanetMap planetMap;

    public Rover(int x, int y, Direction direction, PlanetMap planetMap) {
        this.coordinates = new Coordinates(x, y);
        this.direction = direction;
        this.planetMap = planetMap;
    }

    public void perform(String commandMsg) throws IllegalCommandException, ObstacleOnPathException {
        CommandParser parser = new CommandParser(commandMsg);
        List<Command> commands = parser.parse();

        for (Command command : commands) {
            command.execute(this);
        }
    }

    public void turn(To to) {
        switch (to) {
            case LEFT:
                direction = direction.left();
                break;
            case RIGHT:
                direction = direction.right();
                break;
            default:
                throw new IllegalStateException("Operation not supported by this engine");
        }
        printState(to);
    }

    public void move(To to) throws ObstacleOnPathException {
        switch (to) {
            case FORWARD:
                nextCoordinates = new Coordinates(coordinates.getX() + direction.getXHop(), coordinates.getY() + direction.getYHop());
                break;
            case BACKWARD:
                nextCoordinates = new Coordinates(coordinates.getX() - direction.getXHop(), coordinates.getY() - direction.getYHop());
                break;
            default:
                throw new IllegalStateException("Operation not supported by this engine");
        }

        nextCoordinates = planetMap.checkCoordinates(nextCoordinates);
        if (planetMap.hasObstacle(nextCoordinates)) throw new ObstacleOnPathException();

        coordinates = nextCoordinates;

        printState(to);
    }

    private void printState(To to) {
        log.info("Command executed : {}", to.getCharCommand());
        log.info("\n{}", planetMap.render(coordinates, direction));
    }

    class CommandParser {

        String commandsString;

        private Map<To, Command> commandMap = new EnumMap<To, Command>(To.class) {
            {
                put(To.FORWARD, new MoveForward());
                put(To.BACKWARD, new MoveBackward());
                put(To.LEFT, new RotateLeft());
                put(To.RIGHT, new RotateRight());
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
