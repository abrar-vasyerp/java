package Bank;

public class BankAccount {
    private int balance=100;
    public synchronized void withdraw(int amount){
        System.out.println(Thread.currentThread().getName()+"Attempting...");
        if(balance>=amount){

            System.out.println(Thread.currentThread().getName()+"Proceeding withdraw");
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            balance-=amount;
            System.out.println(Thread.currentThread().getName()+"Completed");
        }
        else{
            System.out.println("Insufficient Balance");
        }
    }
}
