import java.util.concurrent.locks.ReentrantLock;

public class ReentrantInterruptTest {
	public static void main(String[] args) throws InterruptedException {
		ReentrantLock lock = new ReentrantLock(Boolean.TRUE);
		lock.lock();
		
        Thread t1 = new Thread(()-> {
            try {
                lock.lock();
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted.");
            }
        });
        t1.start();
        Thread.sleep(1000);
        t1.interrupt();

	}

}
