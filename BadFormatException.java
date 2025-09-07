import java.util.InputMismatchException;
public class BadFormatException extends InputMismatchException {
    public BadFormatException() {
        System.out.println("Bad Format Exception.");
    }
    public BadFormatException(String message) {
        super(message);
    }
}