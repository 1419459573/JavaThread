import java.util.ArrayList;
import java.util.ListIterator;

class IteTask implements Runnable{
    ArrayList<String> a;
    IteTask(ArrayList<String> a){
        this.a=a;
    }
    @Override
    public void run() {
		ListIterator<String> iterator = a.listIterator();
		while (iterator.hasNext()) {
			int index = iterator.nextIndex();
			String element = iterator.next();
			if (element.equals("…œ∫£")) {
				iterator.remove();
			}
			System.out.println("Index=" + index + ", Element=" + element);
		}
	}
}