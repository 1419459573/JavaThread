import java.util.concurrent.BlockingQueue;

public	class BQConsumer extends Thread {
		private final BlockingQueue<String> queue;
		public BQConsumer(BlockingQueue<String> queue) {
			this.queue = queue;
		}

		public void run() {
			while (true) {
				try {
					String str = this.queue.take();
					System.out.println("Consumer took: " + str);
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
					break;
				}
			}
		}
	}