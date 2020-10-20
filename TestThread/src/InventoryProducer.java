class InventoryProducer implements Runnable{
    Inventory inv;
    InventoryProducer(Inventory inv){
        this.inv=inv;
    }
    public void run() {
    	for (int i=0; i<10; i++) {
	    	inv.stockin2(3);
	    	try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	}
    }
}