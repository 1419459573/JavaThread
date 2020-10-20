public class VisibleTest {
	private static volatile boolean initFlag = false;
	public static void main(String[] args) throws InterruptedException {
		new Thread(() -> {
			System.out.println("waiting...");
			while (!initFlag) {
			}
			System.out.println("success...");
		}).start();
		Thread.sleep(2000);
		new Thread(()-> {
			prepareData();
		}).start();
	}
	public static void prepareData() {
		System.out.println("set flag start");
		initFlag = true;
		System.out.println("set flag end");
	}
}
