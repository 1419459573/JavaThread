import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Resource{  
        private String name;  
        private int count=1;  
        private boolean flag=false;  
        private Lock lock = new ReentrantLock();/*Lock��һ���ӿڣ�ReentrantLock�Ǹýӿڵ�һ��ֱ�����ࡣ*/  
        private Condition condition_pro=lock.newCondition(); /*�������������߷����Condition����*/  
        private Condition condition_con=lock.newCondition(); /*ʹ��ͬһ�������������������߷����Condition����*/  
          
        public void set(String name){  
            lock.lock();//��ס�������lock.unlock()֮��Ĵ���  
            try{  
                while(flag)  
                    condition_pro.await(); //�������߳���conndition_pro�����ϵȴ�  
                this.name=name+"---"+count++;  
                System.out.println(Thread.currentThread().getName()+"...������..."+this.name);  
                flag=true;  
                 condition_con.signalAll();  
            } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
            finally{  
                lock.unlock(); //unlock()Ҫ����finally���С�  
            }  
        }  
        public void out(){  
            lock.lock(); //��ס�������lock.unlock()֮��Ĵ���  
            try{  
                while(!flag)  
                    condition_con.await(); //�������߳���conndition_con�����ϵȴ�  
            System.out.println(Thread.currentThread().getName()+"...������..."+this.name);  
            flag=false;  
            condition_pro.signalAll(); /*����������condition_pro�����µȴ����̣߳�Ҳ���ǻ��������������߳�*/  
            } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
            finally{  
                lock.unlock();  
            }  
        }  
    }