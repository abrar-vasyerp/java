package Bank;

public class Demo {
    public static void main(String[] args) {
        BankAccount bank=new BankAccount();
        Runnable task=new Runnable() {
            @Override
            public void run() {
                bank.withdraw(50);
            }
        };
        Thread t1=new Thread(task,"First");
        Thread t2=new Thread(task,"Second");
        t1.start();
        t2.start();


    }
}
