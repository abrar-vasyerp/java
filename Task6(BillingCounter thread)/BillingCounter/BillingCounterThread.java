package BillingCounter;

public class BillingCounterThread extends Thread{
    private StockService stockService;
    private String name;

    public BillingCounterThread(String name,StockService stockService) {
        super(name);
        this.stockService = stockService;
    }

    @Override
    public void run() {
        stockService.buyItem(1);

    }
}
