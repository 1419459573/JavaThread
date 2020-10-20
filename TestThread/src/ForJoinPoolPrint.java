import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class ForJoinPoolPrint {
    
    public static void main(String[] args) throws Exception{
        PrintTask task = new PrintTask(0, 300);

        ForkJoinPool pool = new ForkJoinPool();
        pool.submit(task);

        pool.awaitTermination(2, TimeUnit.SECONDS);
        pool.shutdown();
    }
}