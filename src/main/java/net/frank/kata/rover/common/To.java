package net.frank.kata.rover.common;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public enum To {

    FORWARD('f'),
    BACKWARD('b'),
    LEFT('l'),
    RIGHT('r');

    private final char charCommand;

    To(char charCommand) {
        this.charCommand = charCommand;
    }

    public char getCharCommand() {
        return charCommand;
    }

    public static Set<Character> commands() {
        Set<Character> set = new HashSet<>();
        for (To t : values()) {
            set.add(t.getCharCommand());
        }
        return Collections.unmodifiableSet(set);
    }

    public static To fromCharCommand(char command) {
        return Arrays.stream(To.values())
                .filter(e -> e.charCommand == command)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("Unsupported command '%s.'", command)));
    }
}
