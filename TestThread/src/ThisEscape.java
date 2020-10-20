public class ThisEscape {
    final String a;
    static ThisEscape t;
    public ThisEscape() {
        t = this;       
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a = "test";    
    }
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            new ThisEscape();
        });
        Thread t2 = new Thread(() -> {
            System.out.println(ThisEscape.t.a);
        });
        t1.start();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//        }
        t2.start();
    }}