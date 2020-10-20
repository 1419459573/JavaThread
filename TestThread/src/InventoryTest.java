import java.util.Random;

public class InventoryTest {
    public static void main(String[] args) {
//        Inventory inv=new Inventory(20);
//        Thread t1=new Thread(new InventoryProducer(inv));
//        Thread t3=new Thread(new InventoryConsumer(inv));
//        t1.start();
//        t3.start();
        
        Inventory2 inv=new Inventory2(1000);
        InventoryWorker worker = new InventoryWorker(inv);
        Thread t1=new Thread(worker);
        Thread t2=new Thread(worker);
        t1.start();
        t2.start();
        
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        System.out.println("balance : "+inv.getBalance());
    }
}