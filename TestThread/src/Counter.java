import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int count = 100;    
    private Lock lock = new ReentrantLock();
    public void desc(){
    	lock.lock();
    	try {
	    	if (count >= 0){
		        System.out.println(Thread.currentThread().getName() +"--->"+count);
		        count--;
	    	}
    	}
    	finally {
    		lock.unlock();
    	}
    }
    public int getCount() {
        return count;
    }
    public static void main(String[] args) {
        Counter counter = new Counter();
        Runnable runnable = ()-> {
                while(counter.getCount()>=0)
                    counter.desc();
        };

        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}
