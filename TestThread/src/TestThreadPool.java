import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThreadPool {
	public static void main(String[] args) {
//		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
//		for (int i = 0; i < 10; i++) { 
//			fixedThreadPool.execute(
//				()->{System.out.println(Thread.currentThread().getName());});
//		}
//		fixedThreadPool.shutdown();
		
		
		
		
//		for (int i = 0; i < 20; i++) {  
//			final int index = i;  
//			fixedThreadPool.execute(()-> {  
//					try {  
//						System.out.println(index);  
//						Thread.sleep(3000);  
//					} catch (InterruptedException e) {  
//						e.printStackTrace();  
//					}  
//				}  
//			);  
//		}  
	
	   ThreadPoolExecutor threadPoolExecutor = 
			   new ThreadPoolExecutor(3, 6, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<>(5));
	   ExecutorCompletionService<String> executorCompletionService = 
			   new ExecutorCompletionService<>(threadPoolExecutor);
       for (int i = 0; i < 20; i++) {
			try {
              executorCompletionService.submit(()-> {  
					try {  
						Thread.sleep(3000);  
					} catch (InterruptedException e) {  
						e.printStackTrace();  
					}  
				},"testtask"+i);

                 System.out.print(" New task: testtask" + i);
                 System.out.print(" ActiveCount: " + threadPoolExecutor.getActiveCount());
                 System.out.print(" poolSize: " + threadPoolExecutor.getPoolSize());
                 System.out.print(" queueSize: " + threadPoolExecutor.getQueue().size());
                 System.out.println(" taskCount: " + threadPoolExecutor.getTaskCount());
           } catch (RejectedExecutionException e) {
                 System.out.println("Reject£º" + i);
           }
           try {
              Thread.sleep(200);
           } catch (InterruptedException e) {
              e.printStackTrace();
           }
        }

	   threadPoolExecutor.shutdown();

	}
}
