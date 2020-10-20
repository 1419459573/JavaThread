import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Inventory {
    private int balance;
    private Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();

    public Inventory(int balance) {
         this.balance = balance;
    }
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }   
    public void get(int quantity) {
        synchronized (this) {
	        int newBalance = balance - quantity;
	        this.setBalance(newBalance);
	        System.out.println(Thread.currentThread().getName()+" got :"+quantity +", balance : "+getBalance());
        }
    }
    public void ship(int quantity) {
        synchronized (this) {
        	while (balance<quantity) {
        		try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
        	}
//        	if (balance>=quantity) {
		        int newBalance = balance - quantity;
		        this.setBalance(newBalance);
		        System.out.println(Thread.currentThread().getName()+" Ship, balance : "+getBalance());
//        	}
	        notify();
        }
    }
    public void stockin(int quantity) {
        synchronized (this) {
        	while (balance>=1000) {
        		try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
        	}
//        	if (balance<1000) {
		        int newBalance = balance + quantity;
		        this.setBalance(newBalance);
		        System.out.println(Thread.currentThread().getName()+" Stock in, balance : "+getBalance());
//        	}
	        notify();
        }
    }
    public void ship2(int quantity) {
    	lock.lock();
    	try {
	    	while (balance<quantity) {
					condition2.await();
	    	}
	        int newBalance = balance - quantity;
	        this.setBalance(newBalance);
	        System.out.println(Thread.currentThread().getName()+" Ship, balance : "+getBalance());
		    condition1.signal();
    	}catch (InterruptedException e) {    		
    	}finally {
    		lock.unlock();
    	}
    }
    public void stockin2(int quantity) {
    	lock.lock();
    	try {
	    	while (balance>=1000) {
					condition1.await();
	    	}
	        int newBalance = balance + quantity;
	        this.setBalance(newBalance);
	        System.out.println(Thread.currentThread().getName()+" Stock in, balance : "+getBalance());
	        condition2.signal();
    	}catch (InterruptedException e) {    		
    	}finally {
    		lock.unlock();
    	}
    }
}