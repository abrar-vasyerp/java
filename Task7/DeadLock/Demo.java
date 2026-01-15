package DeadLock;
public class Demo {
    public static void main(String[] args) {
        Pen pen=new Pen();
        Paper paper=new Paper();
        Runnable task1=new Runnable(){
            @Override
            public void run(){
                pen.writingWithPaperTryPen(paper);
            }
        };
        Runnable task2=new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                synchronized (pen){
                    paper.writtingWithPenTryPaper(pen);
                }

                
            }
            
        };
        Thread thread1=new Thread(task1,"Thread1");
        Thread thread2=new Thread(task2,"Thread2");
        thread1.start();
        thread2.start();
    }
}