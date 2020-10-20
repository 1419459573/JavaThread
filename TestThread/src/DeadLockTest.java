
public class DeadLockTest {
    static Object o1 = new Object();
    static Object o2 = new Object();
    
    public static void main(String[] args) {
        Thread t1=new Thread(new DeadLock1());
        Thread t2=new Thread(new DeadLock2());
        t1.start();
        t2.start();
    }
}
