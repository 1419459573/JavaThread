import java.util.concurrent.locks.LockSupport;

public class TestThread extends Thread {
	private byte[] lock = new byte[0];
	
	public TestThread(byte[] lock) {
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

//        synchronized(lock) {
//    	try {
//			lock.wait();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}  	
//    }
        
//        LockSupport.park();
        
        System.out.println("thread done £º"+Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException{
    	//System.out.println(Thread.currentThread().getName());

    	byte[] lock = new byte[0];
        Thread t1 = new TestThread(lock);
        t1.start();
        Thread.sleep(100);
        synchronized (lock){
        	System.out.println(Thread.currentThread().getName()+ " Done.");
        }
      //t1.join();
        //Thread.sleep(100);
        //System.out.println(t1.getState());
        //LockSupport.unpark(t1);
//        synchronized (lock){
//            lock.notify();
//        }
//        Thread.sleep(100);
//        System.out.println(t1.getState());
        
//        Thread t2 = new TestThread(lock);
//        t2.start();
//        
//        try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//        
//        System.out.println("thread 2 state £º"+t2.getState());
//        
    }
}