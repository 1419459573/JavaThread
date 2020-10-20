class InventoryConsumer implements Runnable{
    Inventory inv;
    InventoryConsumer(Inventory inv){
        this.inv=inv;
    }
    public void run() {
    	for (int i=0; i<10; i++) {
	    	inv.ship2(5);
	    	try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	}
    }
}