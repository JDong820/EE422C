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

    public Peg getGuess() {
        return guess;
    }

    public MastermindResult getResult() {
        return result;
    }
}
