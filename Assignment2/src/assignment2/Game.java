package assignment2;

class Game {
    final boolean isTestMode;

    Game(boolean mode) {
        isTestMode = mode;
    }

    public void runGame() {
        printInstructions();
    }

    public static void printInstructions() {
        System.out.print("You lost the game.");
    }
}
