package Exceptions;

public class AlreadyPickedHeroException extends Exception{
    public AlreadyPickedHeroException(String message) {
        super(message);
    }
}
