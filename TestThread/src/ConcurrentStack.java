
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

        // 节点B出栈
        Thread thread1 = new Thread(() -> {
            // 设置线程1执行出栈比较久，用了5s
            Node node = stack.pop(5);
            System.out.println(Thread.currentThread()+" pop B: "+node.item);
        },"thread1");
        thread1.start();

        // 线程2执行出栈之后再入栈：先让A和B出栈，
        // 然后D，C，B入栈（B在栈顶）
        Thread thread2 = new Thread(() -> {
            // 先让A和B出栈
            Node B = stack.pop(0);
            stack.pop(0);

            // 入栈
            // 注意：线程2实现了节点的循环利用，
            // 它先将栈里面的内容全部出栈，然后入栈，最后栈顶的内容是之前出栈的Node
            stack.push(new Node("D"));
            stack.push(new Node("C"));
            stack.push(B);
            System.out.println(Thread.currentThread()+" pop B: "+B.item);
        },"thread2");
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println("main pop C : "+stack.pop(0).item); // 预期结果弹出C
        System.out.println("main pop D : "+stack.pop(0).item); // 预期结果弹出D
    }
}
