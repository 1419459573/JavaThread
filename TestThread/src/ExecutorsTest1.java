import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsTest1 {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.submit(() -> {
			System.out.println("Hello Thread!");
		});
		executor.shutdown();
		
	}
}
