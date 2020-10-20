import java.util.concurrent.locks.ReentrantLock;

public class ReentrantTest {
	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock(Boolean.TRUE);
//		for (int i=0; i<3; i++) {
//			lock.lock();
//			try {
//				System.out.print("lock test! ");
//			}catch(Exception e){
//			}finally{
//				System.out.println("unlock test!");
//				lock.unlock();
//			}
//		}
		
		if (lock.tryLock()){
			try {
				System.out.print("lock test! ");
			}catch(Exception e){
			}finally{
				System.out.println("unlock test!");
				lock.unlock();
			}
		} else {
			System.out.print("Fail to acquire lock ");
		}
	}

}
