

class InvalidQuantity extends RuntimeException{

    public InvalidQuantity(String msg) {
        super(msg);
    }

}
public class Stock {

    double quantity;
        Stock(double quantity){
             if(quantity<0){
            throw new InvalidQuantity("Quantity must be graterthan zero");
        }
        this.quantity=quantity;
    }
    public static void main(String[] args) {
        
        
       Stock stock=new Stock(-5);
        

        
    }
}
