package Database.Exceptions;

public class FailedToExecuteException extends Exception {
    public FailedToExecuteException() {
        super("Execution failed");
    }
}
