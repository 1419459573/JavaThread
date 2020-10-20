
public class Processor4 implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(1000000000);
            System.out.println("能否执行这里");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 11; i++) {
            System.out.println(Thread.currentThread().getName() + "========>" + i);
        }
    }
}