
public class Processor1 implements Runnable {
    @Override
    public void run() {
        Thread t = Thread.currentThread();// t������ڴ��ַָ����߳�Ϊ"t1�̶߳���"
        System.out.println(t.getName());
        System.out.println(t.getId());
    }
}