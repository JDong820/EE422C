package assignment3;

@SuppressWarnings("serial")
public class InvalidColorCodeException extends RuntimeException {

    public InvalidColorCodeException() {
        super();
        System.err.println("Invalid Color. Try again");
    }

    public InvalidColorCodeException(String msg) {
        super(msg);
    }
}
