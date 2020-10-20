
public class Processor3 implements Runnable {

    /**
     * Thread中的run方法不能抛出异常,所以重写runn方法之后,在run方法的声明位置上不能使用throws 所以run方法中的异常只能try...catch...
     */
    @Override
    public void run() {
        for (int i = 0; i < 11; i++) {
            System.out.println(Thread.currentThread().getName() + "========>" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}