import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteTest1 {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    
    public void read() {
        try {
            lock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + " start");
            Thread.sleep(10000);
            System.out.println(Thread.currentThread().getName() + " end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }
    public static void main(String[] args) {
        final ReadWriteTest1 myTask = new ReadWriteTest1();
        
        Thread t1 = new Thread(()-> {
                myTask.read();
        });
        t1.setName("t1");       
        Thread t2 = new Thread(()-> {
                myTask.read();
        });
        t2.setName("t2");
        
        t1.start();
        t2.start();
    }
}
