package common.exceptions;

public class InvalidCommandNameException extends Exception{
    public InvalidCommandNameException(String message){
        super(message);
    }
}