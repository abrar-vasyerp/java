import java.math.BigDecimal;
import java.util.List;

public class ProductService {
    ProductDAO productDAO=new ProductDAO();

    public void addItem(Product product){
        product.setProductName(product.getProductName().toUpperCase());
        productDAO.insertProduct(product);
    }
    public void getAllProducts(){
        List<Product> productList=productDAO.getAllProducts();
        System.out.println("ProductId  "+" ProductName "+" ProductTax  "+"Product_Price  "+"Created_ON");
        for(Product product:productList){
            System.out.println(product.getProductId()+"               "+product.getProductName()+"    "+product.getTax()+"         "+product.getPrice()+"       "+product.getCreatedOn());
        }
    }
    public void getProductById(int productId){
        System.out.println("ProductId  "+" ProductName "+" ProductTax  "+"Product_Price  "+"Created_ON");
        Product product=productDAO.getProductById(productId);
            System.out.println(product.getProductId()+"               "+product.getProductName()+"    "+product.getTax()+"         "+product.getPrice()+"       "+product.getCreatedOn());

    }
    public void deleteProduct(int productId){
        int i=productDAO.deleteProduct(productId);
        if(i==1)
        System.out.println("row deleted sucessfully");
        else System.out.println("row not deleted");
    }
    public void updateProductNameById(int productId,String productName){
        int i=productDAO.updateProductNameById(productId,productName);
        System.out.println("Product id "+productId+" name changed to "+productName);
    }
    public void updateProductPriceById(int productId, BigDecimal price){
        int i=productDAO.updateProductPriceById(productId,price);
        System.out.println("Product id "+productId+" Price updated to "+price);
    }
}
