public class CustomException extends RuntimeException{
    public CustomException(String msg){
        super(msg);
    }
}
class StockShortageException extends RuntimeException{
    public StockShortageException(String msg){
        super(msg);
    }
}
