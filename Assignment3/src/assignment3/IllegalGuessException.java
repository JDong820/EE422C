package assignment3;

@SuppressWarnings("serial")
public class IllegalGuessException extends RuntimeException {
    
    /**
     * Exception that is thrown when a user gives an guess that cannot be
     * parsed.
     */
    public IllegalGuessException() {
        super();
        //System.err.println("Illegal Guess. Try again.");
    }

    /**
     * Exception that is thrown when a user gives an guess that cannot be
     * parsed, with a message.
     */
    public IllegalGuessException(String msg) {
        super(msg);
    }
}
