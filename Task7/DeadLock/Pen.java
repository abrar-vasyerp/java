package DeadLock;
public class Pen{
   public synchronized void writingWithPaperTryPen(Paper paper){
       System.out.println(Thread.currentThread().getName()+"is have Pen and trying for paper");
       paper.finishWriting();
   }
    public synchronized void finishWriting(){
        System.out.println(Thread.currentThread().getName()+"Pen completed writing");
    }
}