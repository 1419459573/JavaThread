
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class ConcurrentStack {
	AtomicReference<Node> top = new AtomicReference<Node>();
	public void push(Node node){
		Node oldTop;
		do{
			oldTop = top.get();
			node.next = oldTop;
		}while(!top.compareAndSet(oldTop, node));
	}
	public Node pop(int time){
		Node newTop;
		Node oldTop;
		do{
			oldTop = top.get();
			if(oldTop == null){
				return null;
			}
			newTop = oldTop.next;
			try {
				TimeUnit.SECONDS.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}while(!top.compareAndSet(oldTop, newTop));
		
		return oldTop;
	}
	
    public static void main(String[] args) throws InterruptedException {
        ConcurrentStack stack = new ConcurrentStack();
        stack.push(new Node("A"));
        stack.push(new Node("B"));

        // �ڵ�B��ջ
        Thread thread1 = new Thread(() -> {
            // �����߳�1ִ�г�ջ�ȽϾã�����5s
            Node node = stack.pop(5);
            System.out.println(Thread.currentThread()+" pop B: "+node.item);
        },"thread1");
        thread1.start();

        // �߳�2ִ�г�ջ֮������ջ������A��B��ջ��
        // Ȼ��D��C��B��ջ��B��ջ����
        Thread thread2 = new Thread(() -> {
            // ����A��B��ջ
            Node B = stack.pop(0);
            stack.pop(0);

            // ��ջ
            // ע�⣺�߳�2ʵ���˽ڵ��ѭ�����ã�
            // ���Ƚ�ջ���������ȫ����ջ��Ȼ����ջ�����ջ����������֮ǰ��ջ��Node
            stack.push(new Node("D"));
            stack.push(new Node("C"));
            stack.push(B);
            System.out.println(Thread.currentThread()+" pop B: "+B.item);
        },"thread2");
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println("main pop C : "+stack.pop(0).item); // Ԥ�ڽ������C
        System.out.println("main pop D : "+stack.pop(0).item); // Ԥ�ڽ������D
    }
}
