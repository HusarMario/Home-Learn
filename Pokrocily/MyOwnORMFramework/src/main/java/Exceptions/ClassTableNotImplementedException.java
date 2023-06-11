package main.java.Exceptions;

public class ClassTableNotImplementedException extends Exception{
    public ClassTableNotImplementedException() {
        super("This class is not supported in database");
    }
}
