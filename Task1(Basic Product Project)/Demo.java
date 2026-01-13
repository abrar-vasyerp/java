
import java.time.LocalDate;



public class Demo {
    public static void main(String[] args) {
        Product product=new Product();
        product.setId(1);
        product.setName("T-Shirt");
        
        Varient varient=new Varient();
        varient.setId(1);
        varient.setProduct(product);
        varient.setSize("XL");
        varient.setColour("Black");

        StockBatch stockBatch=new StockBatch();
        stockBatch.setId(1);
        stockBatch.setPrice(180);
        stockBatch.setQuantity(10);
        stockBatch.setVarient(varient);
        stockBatch.setExpiryDate(LocalDate.of(2025,01, 26));
        
    }
}
