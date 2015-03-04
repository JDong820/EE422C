package assignment3;

import javax.swing.*;


abstract class Game {
    protected final boolean isTestMode;
    protected GameMode runMode;

    Game() {
        isTestMode = true;
        runMode = GameMode.CONSOLE;
    }

    Game(boolean test, GameMode mode) {
        isTestMode = test;
        runMode = mode;
    }

    abstract public void runGame();
    abstract public void displayInstructions();
}
