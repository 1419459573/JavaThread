import java.util.concurrent.locks.LockSupport;

public class TestThreadWait extends Thread {
	private byte[] lock = new byte[0];
	
	public TestThreadWait(byte[] lock) {
		this.lock = lock;
	}
    @Override
    public void run() {
        System.out.println("new thread £º"+Thread.currentThread().getName());
        synchronized(lock) {
	    	try {
				lock.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}  	
        }
        System.out.println("thread done £º"+Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException{
    	System.out.println(Thread.currentThread().getName());
    	byte[] lock = new byte[0];
        Thread t1 = new TestThreadWait(lock);
        t1.start();
        
        Thread.sleep(100);
        synchronized (lock){
            //lock.notify();
            System.out.println("main done.");
        }
        
        
    }
}