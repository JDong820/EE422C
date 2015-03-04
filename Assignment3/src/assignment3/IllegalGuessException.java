package assignment3;

@SuppressWarnings("serial")
public class IllegalGuessException extends RuntimeException {

    public IllegalGuessException() {
        super();
        //System.err.println("Illegal Guess. Try again.");
    }

    public IllegalGuessException(String msg) {
        super(msg);
    }
}
