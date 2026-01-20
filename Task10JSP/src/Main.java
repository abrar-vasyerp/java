import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        Product product=new Product();
        product.setPrice(new BigDecimal("600"));
        product.setProductName("TSHIRT");
        product.setTax(5.0);
        ProductService productService=new ProductService();
//        productService.addItem(product);

////        productService.getProductById(1);
//        productService.deleteProduct(1);
        productService.updateProductById(2,product);
//        productService.updateProductPriceById(2,new BigDecimal("500"));
        productService.getAllProducts();


    }
}