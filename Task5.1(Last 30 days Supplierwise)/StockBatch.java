import java.time.LocalDate;

public class StockBatch {
    private double quantity;
    private LocalDate expiryDate;
    private Supplier supplier;
    public StockBatch(double quantity, LocalDate expiryDate,Supplier supplier) {
        this.quantity = quantity;
        this.expiryDate = expiryDate;
        this.supplier=supplier;
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

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
