import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorsTest2 {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		Future<String> ft = executor.submit(() -> {
			System.out.println("Hello Thread!");
			return "sucess";
		});
		try {
			System.out.println("return : " + ft.get());
		} catch (Exception e) {
			e.printStackTrace();
		}
		executor.shutdown();
		
	}
}
