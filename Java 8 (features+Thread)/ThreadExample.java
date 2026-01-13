class MyThread extends Thread{

    public void run(){
        System.out.println("MyThread is Runnning");
    }
}
class RunnableThread implements Runnable{
    public void run(){
        System.out.println("RunnableThread is working");
    }
}
public class ThreadExample {
    public static void main(String[] args) {
        MyThread t1=new MyThread();
        t1.start();
        RunnableThread r=new RunnableThread();
        Thread t2=new Thread(r);
        t2.start();

    }
}
