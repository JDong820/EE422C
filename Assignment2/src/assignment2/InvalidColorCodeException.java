package assignment2;

@SuppressWarnings("serial")
public class InvalidColorCodeException extends RuntimeException {

    public InvalidColorCodeException() {
        super();
    }

    public InvalidColorCodeException(String msg) {
        super(msg);
    }
}
