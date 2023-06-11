package main.java.Exceptions;

public class NoIdFoundException extends Exception {
    public NoIdFoundException() {
        super("No ID implemented in table");
    }
}
