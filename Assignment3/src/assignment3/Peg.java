package assignment3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


class Peg {
    private final List<Color> colors;

    Peg(int length) {
        Color[] values = Color.values();
        colors = Collections.unmodifiableList(Arrays.stream(new Random()
                                              .ints(length, 0, values.length-1)
                                              .toArray())
                                              .mapToObj(i -> values[i])
                                              .collect(Collectors.toList()));
    }

    Peg(int length, String userInput) {
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
        if (colors.size() != length) {
            throw new IllegalGuessException();
        }
    }

    /**
     * Accessor method for Color list.
     * @return the list of colours
     */
    public List<Color> getColors() {
        return colors;
    }

    /**
     * @return the String object representing the Peg using coloured codes
     *         from Color
     */
    public String gejColoredString() {
        return colors
               .stream()
               .map(c -> Color.getColoredColorCode(c))
               .collect(Collectors.joining(""));
    }

    /**
     * @return the String object representing the Peg using codes from Color
     */
    @Override
    public String toString() {
        return colors
               .stream()
               .map(c -> Color.getColorCode(c))
               .collect(Collectors.joining(""));
    }

    /**
     * @return true if the colours represented by the internal lists have the
     *         same elements in the same order
     */
    @Override
    public boolean equals(Object o) {
        if (o == null)
            return this == null;
        if (getClass() != o.getClass())
            return false;

        final Peg other = (Peg) o;
        return this.toString().equals(other.toString());
    }
}
