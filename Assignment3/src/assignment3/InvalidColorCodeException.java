package assignment3;

@SuppressWarnings("serial")
public class InvalidColorCodeException extends RuntimeException {

    /**
     * Thrown when an an attempt to parse an invalid color code is made.
     */
    public InvalidColorCodeException() {
        super();
        System.err.println("Invalid Color. Try again");
    }

    /**
     * Thrown when an an attempt to parse an invalid color code is made, with
     * a message.
     */
    public InvalidColorCodeException(String msg) {
        super(msg);
    }
}
