package assignment3;

@SuppressWarnings("serial")
public class InvalidColorCodeException extends RuntimeException {

    /**
     * Constructs a new Color code exception with `null` as its detail message.
     * This may happen anytime an invalid Color code is parsed.
     */
    public InvalidColorCodeException() {
        super();
        System.err.println("Invalid Color. Try again");
    }

    /**
     * Constructs a new Color code exception with the specified detail message.
     * This may happen anytime an invalid Color code is parsed.
     * @param message - the detail message. The detail message is saved for
     * later retrieval by the Throwable.getMessage() method.
     */
    public InvalidColorCodeException(String message) {
        super(message);
    }
}
