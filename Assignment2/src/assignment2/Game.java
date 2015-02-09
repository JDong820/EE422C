package assignment2;

class Game {
    boolean isTestMode;

    Game(boolean mode) {
        isTestMode = mode;
    }


    public void runGame() {
        printInstructions();
    }

    public void printInstructions() {
        System.out.print("You lost the game.");
    }
}
