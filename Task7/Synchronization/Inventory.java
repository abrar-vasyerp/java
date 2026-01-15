public class Inventory{
    public int inventoryId;
    private String productName;
    private double quantity;

    public String getProductName() {
        return productName;
    }

    public Inventory() {
    }

    public Inventory(int inventoryId,double quantity, String productName) {
        this.inventoryId=inventoryId;
        this.quantity = quantity;
        this.productName = productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}