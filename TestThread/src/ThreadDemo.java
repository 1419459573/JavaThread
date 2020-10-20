import java.util.HashMap;

public class ThreadDemo {
	public static void main(String[] args) throws InterruptedException {
		HashMap<Thread,String> hm = new HashMap<>();
		Thread t1 = new Thread(new NewThread());
		Thread t2 = new Thread(new NewThread());
		hm.put(t1, t1.getName());
		hm.put(t2, t2.getName());
		t1.start(); 
		t2.start(); 

		Thread.sleep(1000);
		
		System.out.println(t1.getState());
		System.out.println(t2.getState());

		//		Runnable task = () -> {
//			try {
//				for(int i = 5; i > 0; i--) {
//					System.out.println("Child Thread: " + i);
//					Thread.sleep(100);
//				}
//			} catch (Exception e) {
//			}
//			System.out.println("child thread exit.");
//		};
		
		
		//Thread t1 = new Thread(task);


		//Thread t2 = new Thread(new NewThread());
//		Thread t2 = new Thread(task);
//		System.out.println("Child Thread: " + t2);
//		t2.start(); 

//		try {
//			for(int i = 5; i > 0; i--) {
//				System.out.println("Main Thread: " + i);
//				Thread.sleep(100);
//			}
//		} catch (Exception e) {
//		}
		System.out.println("Main thread exit.");
	}
}
