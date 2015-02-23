package assignment3;


abstract class Game {
    final boolean isTestMode;

    Game(boolean mode) {
        isTestMode = mode;
    }

    abstract public void runGame();
    abstract public void printInstructions();
}
