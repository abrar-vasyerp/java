public class BillItem {
    private int billItemId;
    private int billId;
    private int supplierId;
    private double quantity;
    private int varientId;
    private int stockBatchId;

    public int getBillItemId() {
        return billItemId;
    }

    public void setBillItemId(int billItemId) {
        this.billItemId = billItemId;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public int getVarientId() {
        return varientId;
    }

    public void setVarientId(int varientId) {
        this.varientId = varientId;
    }

    public int getStockBatchId() {
        return stockBatchId;
    }

    public void setStockBatchId(int stockBatchId) {
        this.stockBatchId = stockBatchId;
    }
    
    
}
