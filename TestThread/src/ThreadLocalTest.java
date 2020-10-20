import java.util.Random;
import java.util.stream.IntStream;

public class ThreadLocalTest implements Runnable {
    private final ThreadLocal<Student> studentlocal = new ThreadLocal<>();

    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {  
	        Student student = (Student) studentlocal.get();
	        if (student == null) {
	            student = new Student(Thread.currentThread().getName(),60);
	            studentlocal.set(student);
	        }
	        student.setScore(new Random().nextInt(100));
	        System.out.println(student.getName() + " score is:" + student.getScore());
        } finally {
        	studentlocal.remove();
        }
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    

    public static void main(String[] agrs) {
    	ThreadLocalTest td = new ThreadLocalTest();
        Thread t1 = new Thread(td, "t1");
        Thread t2 = new Thread(td, "t2");
        t1.start();
        t2.start();
        
    }

//public class ThreadLocalTest {    
//    public static void main(String[] agrs) {
//    	ThreadLocal<String> local = new ThreadLocal<>();
//    	IntStream.range(0, 5).forEach(
//	    			i->new Thread(()-> {
//	    					local.set(i+"");
//	    					System.out.println(local.get());
//	    				}).start());
//    }
}
