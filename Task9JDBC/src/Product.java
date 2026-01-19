
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Product {
    private int productId;
    private String productName;
    private double tax;
    private BigDecimal price;
    private Boolean isDeleted;
    private LocalDateTime createdOn;
    private LocalDateTime modifiedOn;

    public Product(int productId, String productName, double tax, BigDecimal price, Boolean isDeleted, LocalDateTime createdOn, LocalDateTime modifiedOn) {
        this.productId = productId;
        this.productName = productName;
        this.tax = tax;
        this.price = price;
        this.isDeleted = isDeleted;
        this.createdOn = createdOn;
        this.modifiedOn = modifiedOn;
    }

    public Product() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(LocalDateTime modifiedOn) {
        this.modifiedOn = modifiedOn;
    }
}
