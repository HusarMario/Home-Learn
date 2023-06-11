package Database.Exceptions;

public class NullPropertyFieldException extends Exception{
    public NullPropertyFieldException() {
        super("Property field is empty");
    }
}
