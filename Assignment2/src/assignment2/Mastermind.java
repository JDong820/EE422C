package assignment2;

import java.io.*;
import java.util.*;


class Mastermind extends Game {
    int remainingGuesses;

    Mastermind(boolean mode) {
        super(mode);
        remainingGuesses = 12;
    }

    public void runGame() {
        printInstructions();
        if (!startPrompt())
            return;
        while (remainingGuesses >= 0) {
            MastermindGuess guess = nextGuess();
            --remainingGuesses;
        }
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
        //while(invalidInput){}
        System.out.print("You have 12 guesses to figure out the secret "
                         + "code or you lose the game.  Are you ready to "
                         + "play? (Y/N):  ");
        String userCommand = nextInput();
        return userCommand.equals("Y") || userCommand.equals("y");
    }

    private MastermindGuess nextGuess() {
        promptGuess();

        boolean validGuess = false;
        MastermindGuess guess = null;
        while (!validGuess) {
            String input = nextInput();
            //TODO: input validation...
            try {
                guess = new MastermindGuess(input);
                validGuess = true;
            } catch (InvalidColorCodeException e) {
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
        System.out.print("\nYou have " + remainingGuesses + " guesses left.\n"
                         + "What is your next guess?\n"
                         + "Type in the characters for your guess and press "
                         + "enter.\n"
                         + "Enter guess: ");
    }

    private void repromptGuess() {
        promptGuess();
    }
}
