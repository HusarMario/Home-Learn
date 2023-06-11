package main.java.Exceptions;

public class ColumnIdMissmatchException extends Exception {
    public ColumnIdMissmatchException() {
        super("Column with ID is missing name");
    }
}
