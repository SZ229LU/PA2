public class IllegalTransactionException extends Exception {
    public IllegalTransactionException() {
        super("Illegal Transaction.");
    }
    public IllegalTransactionException(String message) {
        super(message);
    }
}