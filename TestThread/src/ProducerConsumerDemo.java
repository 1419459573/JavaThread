public class ProducerConsumerDemo{  
    public static void main(String[] args){  
        Resource r=new Resource();  
        Producer pro=new Producer(r);  
        Consumer con=new Consumer(r);  
        Thread t1=new Thread(pro);  
        Thread t2=new Thread(con);  
        Thread t3=new Thread(pro);  
        Thread t4=new Thread(con);  
        t1.start();  
        t2.start();  
        t3.start();  
        t4.start();  
    }  
}