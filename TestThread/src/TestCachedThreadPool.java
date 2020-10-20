import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCachedThreadPool {
	public static void main(String[] args) {
		 ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
	        for (int i = 1; i <= 10; i++) {
	            final int ii = i;
	            try {
	                Thread.sleep(ii * 1);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }

	            cachedThreadPool.execute(
	            		()->System.out.println("name£º" + Thread.currentThread().getName() + "£¬execute" + ii));
	        }
	}
}
