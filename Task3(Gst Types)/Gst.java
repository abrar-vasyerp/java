
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Gst implements TaxStratagy{
    BigDecimal tax;
    BigDecimal amount;
    BigDecimal cgst;
    BigDecimal sgst;
    public Gst(BigDecimal amount,BigDecimal tax) {
        this.amount=amount;
        this.tax=tax;
    }
    @Override
    public BigDecimal calculateTax() {
        // TODO Auto-generated method stub
        cgst =amount.multiply(tax).divide(new BigDecimal("200"), RoundingMode.UP);
        sgst =amount.multiply(tax).divide(new BigDecimal("200"), RoundingMode.UP);
        return cgst.add(sgst);
        

    }

    
}
