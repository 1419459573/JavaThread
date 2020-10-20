import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    private final static Semaphore SEMAPHORE = new Semaphore(5);
    private final static CountDownLatch countDownLatch = new CountDownLatch(8);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 8; i++) {
            final String name = "worker " + i;
            new Thread(() -> {
                    try {
                        SEMAPHORE.acquire();
                        System.out.println(name + "working...");
                        Thread.sleep(2000);

                    } catch (InterruptedException e) {
                        System.out.println(name + "failed");
                    } finally {
                        System.out.println(name + "release");
                        SEMAPHORE.release();
                    }
                    countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        //Thread.sleep(5000);
        System.out.println("finished");
    }
}
