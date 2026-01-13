class Demo{
    public static void main(String[] args){

//        MyThread l=new MyThread("Low Priority");
//        MyThread m=new MyThread("Medium Priority");
//        MyThread h=new MyThread("Highest Priority");
//        l.setPriority(Thread.MIN_PRIORITY);
//        m.setPriority(Thread.NORM_PRIORITY);
//        h.setPriority(Thread.MAX_PRIORITY);
//        l.start();
//        m.start();
//        h.start();
//        h.interrupt();
        Counter counter=new Counter();
        MyThread2 t1=new MyThread2(counter);
        MyThread2 t2=new MyThread2(counter);
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(counter.getCount());
    }
}