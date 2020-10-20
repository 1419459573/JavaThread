public class NewThread implements Runnable {
	public void run() {
		try {
			//for(int i = 3; i > 0; i--) {
				System.out.println("Child Thread: " + Thread.currentThread().getName());
			//	Thread.sleep(100);
			//}
		} catch (Exception e) {
		}
		System.out.println("child thread exit.");
	}
}
