
public class Processor3 implements Runnable {

    /**
     * Thread�е�run���������׳��쳣,������дrunn����֮��,��run����������λ���ϲ���ʹ��throws ����run�����е��쳣ֻ��try...catch...
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