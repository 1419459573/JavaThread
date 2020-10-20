import java.util.concurrent.atomic.AtomicInteger;

public class VolatileTest {
  public static volatile int counter = 0;
  public static AtomicInteger quantity = new AtomicInteger(0);

  public  static void main(String[] args) {
      for (int i = 0; i < 10; i++) {
        	new Thread(() -> {
                  for (int j = 0; j < 1000; j++) {
                	  counter++;
                       quantity.getAndIncrement();
                  }
              }
          ).start();
      }
      while (Thread.activeCount() > 1) {
         Thread.yield();
      }
      System.out.println(counter);
      System.out.println(quantity);
  }
}