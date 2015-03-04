package assignment3;


abstract class Game {
    final boolean isTestMode;
    final boolean swingMode;

    Game(boolean mode) {
        isTestMode = mode;
        swingMode = false;
    }

    Game(boolean test, boolean swing) {
        isTestMode = test;
        swingMode = swing;
    }

    abstract public void runGame();
    abstract public void displayInstructions();
}
