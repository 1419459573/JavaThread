import java.util.concurrent.RecursiveTask;

class SumTask extends RecursiveTask<Integer>{
    private static final int THRESHOLD = 20; //每个小任务 最多只累加20个数
    private int arry[];
    private int start;
    private int end;
    
    public SumTask(int[] arry, int start, int end) {
        super();
        this.arry = arry;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum =0;
        if(end - start <THRESHOLD){
            for(int i= start;i<end;i++){
                sum += arry[i];
            }
            return sum;
        }else {
            int middle = (start+ end)/2;
            SumTask left = new SumTask(arry, start, middle);
            SumTask right = new SumTask(arry, middle, end);
            left.fork();
            right.fork();
            return left.join()+right.join();
        }
    }
}