package assignment2;

import java.io.*;
import java.util.*;


class Mastermind extends Game {
    private int remainingGuesses;
    private final MastermindGuess secret;
    private ArrayList<MastermindGuess> history;
    private int codeLength = 4;

    Mastermind(boolean mode) {
        super(mode);
        remainingGuesses = 12;
        secret = new MastermindGuess(codeLength);
        history = new ArrayList<>();
    }

    public void runGame() {
        printInstructions();
        if (!startPrompt())
            return;
        while (remainingGuesses > 0) {
            MastermindGuess guess = nextGuess();
            if (isTestMode)
                System.out.println("Secret: " + secret);
            history.add(guess);
            --remainingGuesses;
            MastermindResult result = checkGuess(guess);
            printOutput(guess, result);
            if (result.black == codeLength) {
                System.out.println("You win!");
                return;
            }
        }
        if (!isTestMode)
            System.out.println("The secret was: " + secret);
        System.out.println("You lose.");
    }

    public void printInstructions() {
        System.out.print("Initial greeting.\n"
                         + "\n"
                         + "Welcome to Mastermind.  Here are the rules.\n"
                         + "This is a text version of the classic board game "
                         + "Mastermind.\n"
                         + "The computer will think of a secret code. The code "
                         + "consists of 4 colored pegs.\n"
                         + "The pegs MUST be one of six colors: blue, green, "
                         + "orange, purple, red, or yellow. A color may appear "
                         + "more than once in the code. You try to guess what "
                         + "colored pegs are in the code and what order they "
                         + "are in.   After you make a valid guess the result "
                         + "(feedback) will be displayed.\n"
                         + "The result consists of a black peg for each peg "
                         + "you have guessed exactly correct (color and "
                         + "position) in your guess.  For each peg in the "
                         + "guess that is the correct color, but is out of "
                         + "position, you get a white peg.  For each peg, "
                         + "which is fully incorrect, you get no feedback.\n"
                         + "\n"
                         + "Only the first letter of the color is displayed. "
                         + "B for Blue, R for Red, and so forth.\n"
                         + "When entering guesses you only need to enter the "
                         + "first character of each color as a capital letter.\n");
    }

    private boolean startPrompt() {
        while (true) {
            System.out.print("You have 12 guesses to figure out the secret "
                             + "code or you lose the game.  Are you ready to "
                             + "play? (Y/N):  ");
            String userCommand = nextInput();
            if (userCommand.equals("Y") || userCommand.equals("y")) {
                return true;
            } else if (userCommand.equals("N") || userCommand.equals("n")) {
                return false;
            }
        }
    }

    private MastermindGuess nextGuess() {
        boolean validGuess = false;
        MastermindGuess guess = null;

        promptGuess();
        while (!validGuess) {
            String input = nextInput();
            if (input.equals("history")) {
                printHistory();
                continue;
            } else {
                // Parse input guess, ignoring if invalid.
                // After parsing, check length.
                try {
                    guess = new MastermindGuess(input);
                    if (guess.getColors().size() == secret.getColors().size()) {
                        validGuess = true;
                    }
                } catch (InvalidColorCodeException e) {
                }
            }
            if (!validGuess) {
                repromptGuess();
            }
        }
        return guess;
    }

    private String nextInput() {
        Scanner in = new Scanner(System.in);
        String userInput = in.nextLine();
        return userInput;
    }

    private void promptGuess() {
        System.out.print("\nYou have " + remainingGuesses
                         + " guess" + ((remainingGuesses == 1) ? "" : "es")
                         + " left.\n"
                         + "What is your next guess?\n"
                         + "Type in the characters for your guess and press "
                         + "enter.\n"
                         + "Enter guess: ");
    }

    private void repromptGuess() {
        promptGuess();
    }

    private void printHistory() {
        for (MastermindGuess g: history) {
            System.out.println(g);
        }
    }

    private MastermindResult checkGuess(MastermindGuess g) {
        int black = 0;
        int white = 0;

        ArrayList<Color> guessData = new ArrayList<>();
        ArrayList<Color> secretData = new ArrayList<>();
        guessData.addAll(g.getColors());
        secretData.addAll(secret.getColors());

        for (int n=0; n < codeLength; n++) {
            if(guessData.get(n).equals(secretData.get(n))) {
                ++black;
                guessData.set(n, Color.VOID);
                secretData.set(n, Color.VOID);
            }
        }
        for (int n = 0; n < codeLength; n++) {
            for (int j = 0; j < codeLength; j++) {
                if (guessData.get(n).equals(secretData.get(j))) {
                    ++white;
                    guessData.set(n, Color.VOID);
                    secretData.set(j, Color.VOID);
                }
            }
        }
        return new MastermindResult(white, black);
    }

    private void printOutput(MastermindGuess lastGuess,
                             MastermindResult result) {
        System.out.println(lastGuess + " -> Result: " + result);
    }
}
