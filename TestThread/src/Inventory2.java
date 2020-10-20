import java.util.concurrent.atomic.AtomicInteger;

class Inventory2 {
	private AtomicInteger balance;

    public Inventory2(int balance) {
         this.balance = new AtomicInteger(balance);
    }

    public int getBalance() {
        return balance.get();
    }

    public void setBalance(int balance) {
        this.balance = new AtomicInteger(balance);
    }
    
    public void get(int quantity) {
    	int oldValue = balance.get();
        int newBalance = oldValue - quantity;
        while (!balance.compareAndSet(oldValue, newBalance)) {
        	oldValue = balance.get();
        	newBalance = oldValue - quantity;
        }
        System.out.println(Thread.currentThread().getName()+" got :"+quantity +", balance : "+newBalance);
    }
}