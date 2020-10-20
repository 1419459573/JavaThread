import java.util.concurrent.locks.LockSupport;

public class TestThreadInterrupt extends Thread {
	private byte[] lock = new byte[0];
	
	public TestThreadInterrupt(byte[] lock) {
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
				System.out.println(Thread.currentThread().isInterrupted());
				Thread.currentThread().interrupt();
			}  	
      }
        
//        synchronized(lock) {
//        	try {
//				Thread.sleep(5000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//				//System.out.println(Thread.currentThread().isInterrupted());
//				//Thread.currentThread().interrupt();
//			}
//        }


//      int i = 0;
//      while(!Thread.currentThread().isInterrupted() && i<Integer.MAX_VALUE){
//          System.out.println(i+" whileÑ­»·");
//          i++;
//      }


        System.out.println("thread done £º"+Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException{
    	System.out.println(Thread.currentThread().getName());

    	byte[] lock = new byte[0];
        Thread t1 = new TestThreadInterrupt(lock);
        t1.start();
        Thread.sleep(1000);
        t1.interrupt();
        synchronized(lock) {
        	System.out.println(Thread.currentThread().getName()+ " Done.");
        }
    }
}