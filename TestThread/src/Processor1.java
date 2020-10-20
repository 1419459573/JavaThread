
public class Processor1 implements Runnable {
    @Override
    public void run() {
        Thread t = Thread.currentThread();// t保存的内存地址指向的线程为"t1线程对象"
        System.out.println(t.getName());
        System.out.println(t.getId());
    }
}