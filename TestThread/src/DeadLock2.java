
public class DeadLock2 implements Runnable {
	@Override
	public void run() {
        while(true) {
            synchronized(DeadLockTest.o1) {
                System.out.println("thread 2 - lock 1");
                synchronized(DeadLockTest.o2) {
                    System.out.println("thread 2 - lock 2");

                }
            }
        }
    }
}
