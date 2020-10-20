import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Resource{  
        private String name;  
        private int count=1;  
        private boolean flag=false;  
        private Lock lock = new ReentrantLock();/*Lock是一个接口，ReentrantLock是该接口的一个直接子类。*/  
        private Condition condition_pro=lock.newCondition(); /*创建代表生产者方面的Condition对象*/  
        private Condition condition_con=lock.newCondition(); /*使用同一个锁，创建代表消费者方面的Condition对象*/  
          
        public void set(String name){  
            lock.lock();//锁住此语句与lock.unlock()之间的代码  
            try{  
                while(flag)  
                    condition_pro.await(); //生产者线程在conndition_pro对象上等待  
                this.name=name+"---"+count++;  
                System.out.println(Thread.currentThread().getName()+"...生产者..."+this.name);  
                flag=true;  
                 condition_con.signalAll();  
            } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
            finally{  
                lock.unlock(); //unlock()要放在finally块中。  
            }  
        }  
        public void out(){  
            lock.lock(); //锁住此语句与lock.unlock()之间的代码  
            try{  
                while(!flag)  
                    condition_con.await(); //消费者线程在conndition_con对象上等待  
            System.out.println(Thread.currentThread().getName()+"...消费者..."+this.name);  
            flag=false;  
            condition_pro.signalAll(); /*唤醒所有在condition_pro对象下等待的线程，也就是唤醒所有生产者线程*/  
            } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
            finally{  
                lock.unlock();  
            }  
        }  
    }