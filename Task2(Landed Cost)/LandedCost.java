
import java.math.BigDecimal;

class LandedCost{
    static BigDecimal productCost;
    static BigDecimal shipping;
    static BigDecimal insurance;
    static BigDecimal duties;
    static BigDecimal tax;
    static BigDecimal landedCost;
    public static void main(String[] args) {
    productCost=BigDecimal.valueOf(1000.005454545);
    shipping=BigDecimal.valueOf(40.0);
    insurance=BigDecimal.valueOf(20.0);
    duties=BigDecimal.valueOf(100.0);
    tax=BigDecimal.valueOf(50.0);
    landedCost=productCost.add(shipping)
                          .add(insurance)
                          .add(duties)
                          .add(tax);
    
    System.out.print(landedCost);   
    }
}