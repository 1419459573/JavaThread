import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableThreadTest implements Callable<Integer> {
    @Override  
    public Integer call() throws Exception {  
        int i = 0;  
        for(;i<3;i++) {  
            System.out.println(Thread.currentThread().getName()+" "+i);  
        }  
        return i;  
    }  
    public static void main(String[] args) {  
        CallableThreadTest ctt = new CallableThreadTest();  
        FutureTask<Integer> ft = new FutureTask<>(ctt);  

        new Thread(ft,"Child Thread").start();  

        try {  
            System.out.println("Child thread return£º"+ft.get());  
        } catch (Exception e) {  
        	e.printStackTrace();
        }   

        System.out.println(Thread.currentThread().getName());  
    }
    

}