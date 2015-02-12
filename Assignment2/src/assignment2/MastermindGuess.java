package assignment2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


class MastermindGuess {
    private final List<Color> colors;

    MastermindGuess(int length) {
        Color[] values = Color.values();
        colors = Collections.unmodifiableList(Arrays.stream(new Random()
                                              .ints(length, 0, values.length-1)
                                              .toArray())
                                              .mapToObj(i -> values[i])
                                              .collect(Collectors.toList()));
    }

    MastermindGuess(String userInput) {
        colors = Collections
                 .unmodifiableList(userInput
                                   .chars()
                                   .mapToObj(c -> Color.getColorFromCode((char)c))
                                   .collect(Collectors.toList()));
    }

    public List<Color> getColors() {
        return colors;
    }

    public String toString() {
        return colors
               .stream()
               .map(c -> Color.getColoredColorCode(c))
               .collect(Collectors.joining(""));
    }
}
