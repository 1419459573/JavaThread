
	public class ReExLockTest {
	    private int value;
	    private ReExLock lock = new ReExLock();

	    public int incrementAndGet() {
	        lock.lock();
	        try {
	            Thread.sleep(10);
		        value ++;
	        } catch (InterruptedException e) {
	        } finally {
		        lock.unlock();
	        }
	        return value;
	    }

	    public void reenter(int n) {
	    	if (n == 0) return;
	    	
	        lock.lock();
	        try {
		        System.out.println("a");
		        reenter(--n);
	        } finally {
		        lock.unlock();
	        }
	    }

	    public static void main(String[] args) {
	    	ReExLockTest testLock = new ReExLockTest();

	        Runnable runnable = () -> {
	          for (int i = 0; i<10; i++) {
	              System.out.println(
	            		  Thread.currentThread().getId()+
	            		  ",value£º" + 
	           			  testLock.incrementAndGet());
	          }
	        };

	        new Thread(runnable).start();
	        new Thread(runnable).start();
	        //new Thread(runnable).start();
	        
	        Runnable reenterrun = () -> testLock.reenter(3);
	        new Thread(reenterrun).start();
	    }
	}