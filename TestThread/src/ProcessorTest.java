public class ProcessorTest {

    public static void main(String[] args) {
        //ThreadTest1();
        //ThreadTest2();
        //ThreadTest3();
        //ThreadTest4();
        ThreadTest5();
    }

    /**
     * 三个方法: 获取当前线程对象:Thread.currentThread(); 给线程起名: t1.setName("t1"); 获取线程的名字: t.getName();
     */
    private static void ThreadTest1() {
        Thread t = Thread.currentThread();// t保存的内存地址指向的线程为"主线程"
        System.out.println(t.getId());
        Thread t1 = new Thread(new Processor1());
        // 给线程起名
        t1.setName("t1");
        t1.start();
        Thread t2 = new Thread(new Processor1());
        t2.setName("t2");
        t2.start();
    }

    /**
     * 线程优先级高的获取的CPU时间片相对多一些 优先级: 1-10 最低: 1 最高: 10 默认: 5
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
     * 1.Thread.sleep(毫秒); 2.sleep方法是一个静态方法 3.该方法的作用: 阻塞当前线程,腾出CPU,让给其它线程
     */
    private static void ThreadTest3() {
        Thread t = new Thread(new Processor3());
        t.start();
        for (int i = 0; i < 11; i++) {
            System.out.println(Thread.currentThread().getName() + "========>" + i);
            try {
                t.sleep(5000);// 等同于Thread.sleep(5000);阻塞的还是当前线程,和t线程无关.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 某线程正在休眠,如何打断它的休眠 以下方式依靠的是异常处理机制
     */
    private static void ThreadTest4() {
        try {
            Thread t = new Thread(new Processor4());
            t.start();
            Thread.sleep(5000);// 睡5s
            t.interrupt();// 打断Thread的睡眠
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 如何正确的更好的终止一个正在执行的线程 需求:线程启动5s之后终止.
     */
    private static void ThreadTest5() {
        Processor5 p = new Processor5();
        Thread t = new Thread(p);
        t.start();
        // 5s之后终止
        try {
            Thread.sleep(5000);
            p.isRun = false;
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}