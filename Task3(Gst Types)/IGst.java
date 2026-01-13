import java.math.BigDecimal;
import java.math.RoundingMode;

public class IGst implements TaxStratagy {
    BigDecimal tax;
    BigDecimal amount;
    public IGst(BigDecimal amount,BigDecimal tax) {
        this.amount=amount;
        this.tax=tax;
    }
    @Override
    public BigDecimal calculateTax() {
        // TODO Auto-generated method stub
        return amount.multiply(tax).divide(new BigDecimal("100"), RoundingMode.UP);
        
    }
    
}
