package net.frank.kata.rover.planets;

import net.frank.kata.rover.Coordinates;
import net.frank.kata.rover.Direction;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MarsTest {

    @Test
    public void printMapTest() {
        Mars mars = new Mars();

        String map = mars.getMap(new Coordinates(2, 1), Direction.NORTH);

        assertThat(map).isEqualTo("-----------------------------------------\n" +
                "|   |   |   |   |   |   |   |   |   |   |\n" +
                "-----------------------------------------\n" +
                "|   |   |   |   |   |   |   |   |   |   |\n" +
                "-----------------------------------------\n" +
                "|   | △ |   |   |   |   |   |   |   |   |\n" +
                "-----------------------------------------\n" +
                "|   |   |   |   |   |   |   |   |   |   |\n" +
                "-----------------------------------------\n" +
                "|   |   |   |   |   |   |   |   |   |   |\n" +
                "-----------------------------------------\n" +
                "|   |   |   |   |   |   |   |   |   |   |\n" +
                "-----------------------------------------\n" +
                "|   |   |   |   |   |   |   |   |   |   |\n" +
                "-----------------------------------------\n" +
                "|   |   |   |   |   |   |   |   |   |   |\n" +
                "-----------------------------------------\n" +
                "|   |   |   |   |   |   |   |   |   |   |\n" +
                "-----------------------------------------\n" +
                "|   |   |   |   |   |   |   |   |   |   |\n" +
                "-----------------------------------------\n");
    }

    @Test
    public void printMapWithObstacleTest() {
        Mars mars = new Mars();

        mars.fillObstacles();

        String map = mars.getMap(new Coordinates(2, 1), Direction.NORTH);

        System.out.print(map);

    }

}