package main.java.Exceptions;

public class InvalidIDException extends Exception {

    public InvalidIDException() {
        super("Wrong ID on input");
    }
}
