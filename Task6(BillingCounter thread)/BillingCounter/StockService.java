package BillingCounter;

public class StockService {
    private Stock stock;

    public StockService(Stock stock) {
        this.stock = stock;
    }
    public void buyItem(int quantity){
        if(stock.getQuantity()>=quantity){
            stock.setQuantity(stock.getQuantity()-quantity);
            System.out.println(Thread.currentThread().getName()+" Completed Order");
        }
        else{
            System.out.println("Item not in stock");
        }
    }

}
