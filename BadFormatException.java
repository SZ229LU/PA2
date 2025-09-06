import java.util.InputMismatchException;
public class BadFormatException extends InputMismatchException {
    public BadFormatException() {
        super("Bad Format.");
    }
    public BadFormatException(String message) {
        super(message);
    }
}