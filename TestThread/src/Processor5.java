
public class Processor5 implements Runnable {

    boolean isRun = true;

    @Override
    public void run() {
        for (int i = 0; i < 11; i++) {
            if (isRun) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "========>" + i);
            }
        }
    }
}