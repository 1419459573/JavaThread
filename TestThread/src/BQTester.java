import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BQTester {
	public static void main(String[] args) {
	    BlockingQueue<String> queue = new LinkedBlockingQueue<>(20);

	    new BQProducer(queue).start();
	    new BQProducer(queue).start();
	    new BQConsumer(queue).start();
	    new BQConsumer(queue).start();
	}
}
