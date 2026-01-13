package MyException;

public class InvalidDateException extends RuntimeException{
    public InvalidDateException(String msg){
        super(msg);
    }
}
