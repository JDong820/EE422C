package assignment2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


class MastermindGuess {
    final List<Color> colors;

    MastermindGuess(String userInput) {
        colors = userInput
                 .chars()
                 .mapToObj(c -> Color.getColorFromCode((char)c))
                 .collect(Collectors.toList());
    }
}
