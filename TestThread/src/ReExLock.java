import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ReExLock implements Lock {
	    private Sync sync = new Sync();

	    @Override
	    public void lock() {
	        sync.acquire(1);
	    }
	    @Override
	    public void unlock() {
	        sync.release(1);
	    }

	    @Override
	    public void lockInterruptibly() throws InterruptedException {
	        sync.acquireInterruptibly(1);
	    }

	    @Override
	    public boolean tryLock() {
	        return sync.tryAcquire(1);
	    }

	    @Override
	    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
	        return sync.tryAcquireNanos(1, unit.toNanos(time));
	    }


	    @Override
	    public Condition newCondition() {
	        return sync.newCondition();
	    }

	    private class Sync extends AbstractQueuedSynchronizer { 
	        @Override
	        protected boolean tryAcquire(int arg) {
	            int state = getState();
	            Thread t = Thread.currentThread();

	            if (state == 0) {
	                if (compareAndSetState(0, arg)) {
	                    setExclusiveOwnerThread(Thread.currentThread());
	                    return true;
	                }
	            } 
//	            else if(getExclusiveOwnerThread() == t) {
//	                setState(state + 1);
//	                return true;
//	            }
	            return false;
	        }

	        protected boolean tryRelease(int arg) {
	            if (Thread.currentThread() != getExclusiveOwnerThread()) {
	                throw new RuntimeException();
	            }

	            int state = getState() - arg;
	            setState(state);

	            if (state == 0) {
	                setExclusiveOwnerThread(null);
	                return true;
	            }
	            return false;
	        }

	        protected ConditionObject newCondition() {
	            return new ConditionObject();
	        }
	    }

	}