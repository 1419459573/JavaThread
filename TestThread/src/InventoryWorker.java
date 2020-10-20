import java.util.Random;

class InventoryWorker implements Runnable{
    Inventory2 inv;
    private ThreadLocal<Integer> bag = new ThreadLocal<>();

    InventoryWorker(Inventory2 inv){
        this.inv=inv;    	
    }

    @Override
    public void run() {
        Random r = new Random();
    	bag.set(r.nextInt(10));

    	for (int i=0; i<10; i++) {
	    	inv.get(bag.get());
    		//inv.get(1);
	    	try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	}
    }
}