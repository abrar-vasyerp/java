
import java.math.BigDecimal;


public class Demo {
    

    public static void main(String[] args) {
        BigDecimal amount=new BigDecimal(1000);
        BigDecimal tax=new BigDecimal(18);
        TaxStratagy taxStratagy=new Gst(amount, tax);
        System.out.println(taxStratagy.calculateTax());

    }

    
}
