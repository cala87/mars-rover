package net.frank.kata.rover.planets;

import lombok.extern.slf4j.Slf4j;
import net.frank.kata.rover.Coordinates;
import net.frank.kata.rover.Direction;
import net.frank.kata.rover.Map;
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

        Map marsMap = new Map(Planet.MARS, obstacles);

        String map = marsMap.render(new Coordinates(2, 1), Direction.NORTH);

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
        Map marsMap = new Map(Planet.MARS, 5);


        FailedLandingException failedLandingException = catchThrowableOfType(() -> {
            marsMap.setStartPoint(new Coordinates(2, 1));
            log.info("\n{}", marsMap.render(new Coordinates(2, 1), Direction.NORTH));
        }, FailedLandingException.class);

        if (failedLandingException != null) log.info("Managed test case - {}", failedLandingException);

    }

}