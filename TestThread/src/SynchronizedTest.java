public class SynchronizedTest {
    public static void main(String[] args) {
        SynchronizeTest1();
    }

    private static void SynchronizeTest1() {
        Account account=new Account("Actno-001",5000.0);
        Thread t1=new Thread(new Processor(account));
        Thread t2=new Thread(new Processor(account));
        t1.start();
        t2.start();
    }

}