import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadLocalApplication {
    //public static ThreadLocal<byte[]> threadLocal = new ThreadLocal<>();
    public static ThreadLocal<Boolean> threadLocal2 = ThreadLocal.withInitial(()->false);

    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(8);
        for (int i = 0; i < 50; i++) {
            exec.execute(() -> {
            	System.out.println(Thread.currentThread().getName()+":"+threadLocal2.get());
            	threadLocal2.set(true);
                //threadLocal.set(new byte[10240 * 10240]);
                try {
                    TimeUnit.MILLISECONDS.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //threadLocal.remove();
                    threadLocal2.remove();
                }
            });
        }
        System.out.println(Thread.currentThread().getName()+":finished");
        exec.shutdown();
    }
}
