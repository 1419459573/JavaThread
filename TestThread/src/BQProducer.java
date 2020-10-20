import java.util.concurrent.BlockingQueue;

public class BQProducer extends Thread {
	private final BlockingQueue<String> queue;
	public BQProducer(BlockingQueue<String> queue) {
		this.queue = queue;
	}
	@Override
	public void run() {
		while (true) {
			try {
				this.queue.put("goods");
				System.out.println("Stock in : goods");
				Thread.sleep(1000);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
				break;
			}
		}
	}
}
