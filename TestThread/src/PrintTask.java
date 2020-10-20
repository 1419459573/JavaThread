import java.util.concurrent.RecursiveAction;

class PrintTask extends RecursiveAction{
    private static final int THRESHOLD = 50; //���ֻ�ܴ�ӡ50����
    private int start;
    private int end;
    
    

    public PrintTask(int start, int end) {
        super();
        this.start = start;
        this.end = end;
    }



    @Override
    protected void compute() {
        
        if(end - start < THRESHOLD){
            for(int i=start;i<end;i++){
                System.out.println(Thread.currentThread().getName()+"��iֵ��"+i);
            }
        }else {
            int middle =(start+end)/2;
            PrintTask left = new PrintTask(start, middle);
            PrintTask right = new PrintTask(middle, end);
            left.fork();
            right.fork();
        }
        
    }
    
}