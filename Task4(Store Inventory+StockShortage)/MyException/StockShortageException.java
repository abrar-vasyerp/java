package MyException;

public class StockShortageException extends RuntimeException{
    public StockShortageException(String msg){
        super(msg);
    }
}
