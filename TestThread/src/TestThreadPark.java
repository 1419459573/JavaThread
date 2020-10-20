import java.util.concurrent.locks.LockSupport;

public class TestThreadPark extends Thread {
	private byte[] lock = new byte[0];
	
	public TestThreadPark(byte[] lock) {
		this.lock = lock;
	}
    @Override
    public void run() {
        System.out.println("new thread £º"+Thread.currentThread().getName());
        synchronized(lock) {
        	LockSupport.park();
        }
        System.out.println("thread done £º"+Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException{
    	System.out.println(Thread.currentThread().getName());

    	byte[] lock = new byte[0];
        Thread t1 = new TestThreadPark(lock);
        t1.start();

        Thread.sleep(100);
        //LockSupport.unpark(t1);
        synchronized(lock) {
        	System.out.println(Thread.currentThread().getName()+ " Done.");
        }
    }
}