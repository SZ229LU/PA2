public class IllegalTransactionException extends Exception {
    public IllegalTransactionException() {
        System.out.println("Illegal Transaction Exception.");
    }
    public IllegalTransactionException(String message) {
        super(message);
    }
}