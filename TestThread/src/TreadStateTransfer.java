
public class TreadStateTransfer {
	public static void main(String[] args) {
		byte[] lock = new byte[0];
        TestThread thread = new TestThread(lock);
        thread.start();
        System.out.println(thread.getState());
	}
}
