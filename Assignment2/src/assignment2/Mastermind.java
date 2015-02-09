package assignment2;

class Mastermind extends Game {

    Mastermind(boolean mode) {
        super(mode);
    }


    @Override
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
                       + "first character of each color as a capital letter.");
    }

}
