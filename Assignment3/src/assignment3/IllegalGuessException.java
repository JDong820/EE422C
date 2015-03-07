package assignment3;

@SuppressWarnings("serial")
public class IllegalGuessException extends RuntimeException {
    
    /**
     * Constructs a new exception due to an unparsable guess with a `null`
     * detail message. This may happen anytime a user inputs a guess that
     * cannot be parsed or is the wrong length.
     */
    public IllegalGuessException() {
        super();
        //System.err.println("Illegal Guess. Try again.");
    }

    /**
     * Constructs a new exception due to an unparsable guess with the specified
     * detail message. This may happen anytime a user inputs a guess that
     * cannot be parsed or is the wrong length.
     * @param message - the detail message. The detail message is saved for
     * later retrieval by the Throwable.getMessage() method.
     */
    public IllegalGuessException(String message) {
        super(message);
    }
}
