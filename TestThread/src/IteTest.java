import java.util.ArrayList;

public class IteTest {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
		ArrayList<String> list = new ArrayList<>();
		list.add("����");
		list.add("�Ϻ�");
		list.add("����");
		list.add("����");
		System.out.println("List: " + list);

		Thread t1=new Thread(new IteTask(list));
        Thread t2=new Thread(new IteTask(list));
        t1.start();
        t2.start();
    }

}