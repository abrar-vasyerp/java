import java.time.LocalDate;

public class StockBatch {
    private double quantity;
    private LocalDate expiryDate;

    public StockBatch(double quantity, LocalDate expiryDate) {
        this.quantity = quantity;
        this.expiryDate = expiryDate;
    }
    public StockBatch(){}
    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
    public void reduceQuantity(int quantity) {
        this.quantity -= quantity;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void display(){
        System.out.println("Quantity: "+quantity+" Expiry Date:"+expiryDate);
    }
}
