
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Money {
    static private double money;

    public Money() {
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    BigDecimal moneyBigDecimal;

    public void roundsUp(double money){
        moneyBigDecimal=BigDecimal.valueOf(money);
        moneyBigDecimal=moneyBigDecimal.setScale(2,RoundingMode.UP);
    }
    public BigDecimal getRoundsUp(){
        roundsUp(money);
        return moneyBigDecimal;
    }
    public static void main(String[] args) {
        Money money=new Money();
        money.setMoney(10.8499992);
        System.out.println(money.getRoundsUp());
    }
}
