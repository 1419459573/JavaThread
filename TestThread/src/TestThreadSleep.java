public class TestThreadSleep extends Thread {
	private byte[] lock = new byte[0];
	
	public TestThreadSleep(byte[] lock) {
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
    	byte[] lock = new byte[0];
        Thread t1 = new TestThreadSleep(lock);
        t1.start();
        Thread.sleep(100);
        synchronized (lock){
        	System.out.println(Thread.currentThread().getName()+ " Done.");
        }
   }
}