package assignment2;

class Main {
    public static void main(String[] args) {
        /*
        if (args.length != 1) {
            System.err.println("Error: invalid arguments.");
            System.exit(-1);
        }
        Mastermind mastermind = new Mastermind(args[0]);
        */
        Mastermind mastermind = new Mastermind(true);
        mastermind.runGame();
    }
}
