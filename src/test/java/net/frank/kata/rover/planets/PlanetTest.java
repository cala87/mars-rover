package net.frank.kata.rover.planets;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;



public class PlanetTest {

    @Test
    public void marsTest() {
        assertThat(Planet.MARS.getName()).isEqualTo("Mars");
        assertThat(Planet.MARS.getSize()).isEqualTo(10);
    }
}