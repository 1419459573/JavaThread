
public class DeadLock1 implements Runnable {
	@Override
	public void run() {
        while(true) {
            synchronized(DeadLockTest.o1) {
                System.out.println("thread 1 - lock 1");
                synchronized(DeadLockTest.o2) {
                    System.out.println("thread 1 - lock 2");

                }
            }
        }
    }
}
