package assignment2;

@SuppressWarnings("serial")
public class InvalidColorCodeException extends RuntimeException {

    public InvalidColorCodeException() {
        super();
        System.out.println("Invalid Guess. Try again");
    }

    public InvalidColorCodeException(String msg) {
        super(msg);
        System.out.println("Invalid Guess. Try again");
    }
}
