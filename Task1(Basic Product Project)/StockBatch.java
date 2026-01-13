
import java.time.LocalDate;

public class StockBatch {
    private int stockBatchId;
    private double quantity;
    private LocalDate expiryDate;
    private double price;
    private Varient varient;
    private int supplierId;

    public StockBatch(int stockBatchId,double quantity,LocalDate expiryDate,double price,Varient varient,int supplierId){
        if(price<=0){
            throw new CustomException("Price must be graterthan 0");
        }
        this.stockBatchId=stockBatchId;
        this.quantity=quantity;
        this.expiryDate=expiryDate;
        this.price=price;
        this.varient=varient;
        this.supplierId=supplierId;
    }
    public StockBatch(){}

    public double getQuantity(){
        return quantity;
    }
    public LocalDate getExpiryDate(){
        return expiryDate;
    }
    public double getPrice(){
        return price;
    }
    public Varient getVarient(){
        return varient;
    }
    public int setSupplierId(){
        return supplierId;
    }


    public void setQuantity(int quantity){
        this.quantity=quantity;
    }
    public void setExpiryDate(LocalDate expiryDate){
        this.expiryDate=expiryDate;
    }
    public void setPrice(double price){
        this.price=price;
    }
    public void setVarient(Varient varient){
        this.varient=varient;
    }
    public void setId(int stockBatchId){
        this.stockBatchId=stockBatchId;
    }
    public void setSupplierId(int supplierId){
        this.supplierId=supplierId;
    }


    public void display(){
        System.out.println("Quantity :"+quantity+"expiryDate :"+expiryDate+"Price :"+price);
    }
}
