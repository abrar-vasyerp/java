package DeadLock;
public class Paper{
    public synchronized void writtingWithPenTryPaper(Pen pen){
        System.out.println(Thread.currentThread().getName()+"is have Paper and trying for pen");
        pen.finishWriting();
    }
    public synchronized void finishWriting(){
        System.out.println(Thread.currentThread().getName()+"Paper completed writing");
    }
}