import java.util.concurrent.locks.LockSupport;

public class TestThreadJoin extends Thread {
	private byte[] lock = new byte[0];
	
	public TestThreadJoin(byte[] lock) {
		this.lock = lock;
	}
    @Override
    public void run() {
        System.out.println("new thread £º"+Thread.currentThread().getName());
        synchronized(lock) {
        	try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
        System.out.println("thread done £º"+Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException{
    	System.out.println(Thread.currentThread().getName());

    	byte[] lock = new byte[0];
        Thread t1 = new TestThreadJoin(lock);
        t1.start();
        //t1.join();
       	System.out.println(Thread.currentThread().getName()+ " Done.");
    }
}