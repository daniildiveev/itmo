package common.exceptions;

public class ServerOutputNotSetException extends RuntimeException{
    public ServerOutputNotSetException(String message){
        super(message);
    }
}
