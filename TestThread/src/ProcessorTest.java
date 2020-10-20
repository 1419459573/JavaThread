public class ProcessorTest {

    public static void main(String[] args) {
        //ThreadTest1();
        //ThreadTest2();
        //ThreadTest3();
        //ThreadTest4();
        ThreadTest5();
    }

    /**
     * ��������: ��ȡ��ǰ�̶߳���:Thread.currentThread(); ���߳�����: t1.setName("t1"); ��ȡ�̵߳�����: t.getName();
     */
    private static void ThreadTest1() {
        Thread t = Thread.currentThread();// t������ڴ��ַָ����߳�Ϊ"���߳�"
        System.out.println(t.getId());
        Thread t1 = new Thread(new Processor1());
        // ���߳�����
        t1.setName("t1");
        t1.start();
        Thread t2 = new Thread(new Processor1());
        t2.setName("t2");
        t2.start();
    }

    /**
     * �߳����ȼ��ߵĻ�ȡ��CPUʱ��Ƭ��Զ�һЩ ���ȼ�: 1-10 ���: 1 ���: 10 Ĭ��: 5
     */
    private static void ThreadTest2() {
        Thread t1 = new Processor2();
        Thread t2 = new Processor2();
        t1.setName("t1");
        t2.setName("t2");

        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());
        t1.setPriority(1);
        t2.setPriority(10);

        t1.start();
        t2.start();
    }

    /**
     * 1.Thread.sleep(����); 2.sleep������һ����̬���� 3.�÷���������: ������ǰ�߳�,�ڳ�CPU,�ø������߳�
     */
    private static void ThreadTest3() {
        Thread t = new Thread(new Processor3());
        t.start();
        for (int i = 0; i < 11; i++) {
            System.out.println(Thread.currentThread().getName() + "========>" + i);
            try {
                t.sleep(5000);// ��ͬ��Thread.sleep(5000);�����Ļ��ǵ�ǰ�߳�,��t�߳��޹�.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * ĳ�߳���������,��δ���������� ���·�ʽ���������쳣�������
     */
    private static void ThreadTest4() {
        try {
            Thread t = new Thread(new Processor4());
            t.start();
            Thread.sleep(5000);// ˯5s
            t.interrupt();// ���Thread��˯��
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * �����ȷ�ĸ��õ���ֹһ������ִ�е��߳� ����:�߳�����5s֮����ֹ.
     */
    private static void ThreadTest5() {
        Processor5 p = new Processor5();
        Thread t = new Thread(p);
        t.start();
        // 5s֮����ֹ
        try {
            Thread.sleep(5000);
            p.isRun = false;
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}