public class MyThread extends Thread{
    public void run(){
        for(int i=0;i<5;i++){
            String a="";
            for(int j=0;j<100;j++){
                a+="a";
                System.out.println(Thread.currentThread().getName());
            }
        }
    try{
        Thread.sleep(1000);
    }
    catch (Exception e){
        System.out.println(e.getMessage());
    }
    }

    public MyThread(String msg) {
        super(msg);
    }
}