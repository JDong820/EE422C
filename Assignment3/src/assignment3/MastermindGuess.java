package assignment3;

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
        try {
            colors = Collections
                     .unmodifiableList(userInput
                                       .chars()
                                       .mapToObj(c ->
                                                 Color.getColorFromCode((char)c))
                                       .collect(Collectors.toList()));
        } catch (InvalidColorCodeException e) {
            throw new IllegalGuessException();
        }
    }

    MastermindGuess(int length, String userInput) {
        this(userInput);
        if (colors.size() != length)
            throw new IllegalGuessException();
    }


    public List<Color> getColors() {
        return colors;
    }
    
    @Override
    public String toString() {
        return colors
               .stream()
               .map(c -> Color.getColoredColorCode(c))
               .collect(Collectors.joining(""));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null)
            return this == null;
        if (getClass() != o.getClass())
            return false;

        final MastermindGuess other = (MastermindGuess) o;
        return this.toString().equals(other.toString());
    }
}
