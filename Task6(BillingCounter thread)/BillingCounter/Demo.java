package BillingCounter;

public class Demo {
    public static void main(String[] args) {
        Stock stock =new Stock();
        stock.setQuantity(5);
        StockService stockService=new StockService(stock);
        BillingCounterThread thread;
        for(int i=1;i<=10;i++){
            thread=new BillingCounterThread("Count"+i,stockService);

            thread.start();
        }
    }
}
