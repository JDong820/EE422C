package assignment3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


class MastermindEntry {
    private final Peg guess;
    private final MastermindResult result;

    MastermindEntry(Peg g, MastermindResult r) {
        guess = g;
        result = r;
    }

    /**
     * Accessor method that returns the Peg associated with the entry
     */
    public Peg getGuess() {
        return guess;
    }

    /**
     * Accessor method that returns the result associated with the entry
     */
    public MastermindResult getResult() {
        return result;
    }
}
