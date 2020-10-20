import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;


public class ForJoinPoolTask {
     public static void main(String[] args) throws Exception {
        int[] arr = new int[100];
        Random random = new Random();
        int total =0;
        for(int i=0,len = arr.length;i<len;i++){
            int temp = random.nextInt(20);
            total += (arr[i]=temp);
        }
        System.out.println("��ʼ�������ܺͣ�"+total);
        SumTask task = new SumTask(arr, 0, arr.length);

        ForkJoinPool pool = ForkJoinPool.commonPool();
        Future<Integer> future = pool.submit(task); //�ύ�ֽ��SumTask ����
        System.out.println("���߳�ִ�н����"+future.get());
        pool.shutdown(); //�ر��̳߳�
    }
}

