import java.time.LocalDate;

public class StockBatch {
    private double quantity;
    private LocalDate expiryDate;
    private Supplier supplier;
    private String productName;
    public StockBatch(String productName,double quantity, LocalDate expiryDate,Supplier supplier) {
        this.productName=productName;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
        this.supplier=supplier;
    }
    public StockBatch(){}
    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
    
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
        System.out.println("ProductName:"+productName+"Quantity: "+quantity+" Expiry Date:"+expiryDate);
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
