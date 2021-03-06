package net.frank.kata.rover;

import lombok.extern.slf4j.Slf4j;
import net.frank.kata.rover.planets.FailedLandingException;
import net.frank.kata.rover.planets.Planet;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;


@Slf4j
public class MarsTest {

    @Test
    public void mapWithObstaclesTest() {

        Set<Coordinates> obstacles = new HashSet<>(Arrays.asList(new Coordinates(3, 4), new Coordinates(5, 5)));

        PlanetMap marsPlanetMap = new PlanetMap(Planet.MARS, obstacles);

        String map = marsPlanetMap.render(new Coordinates(2, 1), Direction.NORTH);

        assertThat(map).isEqualTo("  -----------------------------------------\n" +
                                  "9 |   |   |   |   |   |   |   |   |   |   |\n" +
                                  "  -----------------------------------------\n" +
                                  "8 |   |   |   |   |   |   |   |   |   |   |\n" +
                                  "  -----------------------------------------\n" +
                                  "7 |   |   |   |   |   |   |   |   |   |   |\n" +
                                  "  -----------------------------------------\n" +
                                  "6 |   |   |   |   |   |   |   |   |   |   |\n" +
                                  "  -----------------------------------------\n" +
                                  "5 |   |   |   |   |   | O |   |   |   |   |\n" +
                                  "  -----------------------------------------\n" +
                                  "4 |   |   |   | O |   |   |   |   |   |   |\n" +
                                  "  -----------------------------------------\n" +
                                  "3 |   |   |   |   |   |   |   |   |   |   |\n" +
                                  "  -----------------------------------------\n" +
                                  "2 |   |   |   |   |   |   |   |   |   |   |\n" +
                                  "  -----------------------------------------\n" +
                                  "1 |   |   | △ |   |   |   |   |   |   |   |\n" +
                                  "  -----------------------------------------\n" +
                                  "0 |   |   |   |   |   |   |   |   |   |   |\n" +
                                  "  -----------------------------------------\n" +
                                  "    0   1   2   3   4   5   6   7   8   9 ");

        log.info("\n{}", map);
    }

    @Test
    public void printMapWithRandomObstacleTest() {
        PlanetMap marsPlanetMap = new PlanetMap(Planet.MARS, 5);


        FailedLandingException failedLandingException = catchThrowableOfType(() -> {
            marsPlanetMap.init(new Coordinates(2, 1));
            log.info("\n{}", marsPlanetMap.render(new Coordinates(2, 1), Direction.NORTH));
        }, FailedLandingException.class);

        if (failedLandingException != null) log.info("Managed landing failed test case - {}", failedLandingException.getMessage(), failedLandingException);

    }

    @Test
    public void checkCoordinatesWithBorderTest() {

        Set<Coordinates> obstacles = new HashSet<>(Arrays.asList(new Coordinates(3, 4), new Coordinates(5, 5)));

        PlanetMap marsPlanetMap = new PlanetMap(Planet.MARS, obstacles);

        assertThat(marsPlanetMap.checkCoordinatesWithBorders(new Coordinates(10, 2))).isEqualTo(new Coordinates(0, 2));
        assertThat(marsPlanetMap.checkCoordinatesWithBorders(new Coordinates(6, 10))).isEqualTo(new Coordinates(6, 0));
        assertThat(marsPlanetMap.checkCoordinatesWithBorders(new Coordinates(-1, 2))).isEqualTo(new Coordinates(9, 2));
        assertThat(marsPlanetMap.checkCoordinatesWithBorders(new Coordinates(6, -1))).isEqualTo(new Coordinates(6, 9));
    }

}