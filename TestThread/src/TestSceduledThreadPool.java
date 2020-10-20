import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestSceduledThreadPool {
	public static void main(String[] args) {
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        Runnable r1 = 
        		() -> System.out.println("name£º" + Thread.currentThread().getName() + "£¬after 3 seconds.");
        scheduledThreadPool.schedule(r1, 3, TimeUnit.SECONDS);
        Runnable r2 = 
        		() -> System.out.println("name£º" + Thread.currentThread().getName() + "£¬execute: every 3 sconds");
        scheduledThreadPool.scheduleAtFixedRate(r2, 2, 3, TimeUnit.SECONDS);
        Runnable r3 = 
        		() -> System.out.println("name£º" + Thread.currentThread().getName() + "£¬execute:task");
        for (int i = 0; i < 5; i++) {
            scheduledThreadPool.execute(r3);
        }
	}
}
