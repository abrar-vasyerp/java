import java.math.BigDecimal;
import java.sql.*;

public class Main {
    public static void main(String[] args) {

        Product product=new Product();
//        product.setPrice(new BigDecimal("499.0"));
//        product.setProductName("TSHIRT");
//        product.setTax(5.0);
        ProductService productService=new ProductService();
//        productService.addItem(product);
        productService.getAllProducts();
////        productService.getProductById(1);
//        productService.deleteProduct(1);
//        productService.updateProductNameById(2,"tshirt");
//        productService.updateProductPriceById(2,new BigDecimal("500"));


    }
}