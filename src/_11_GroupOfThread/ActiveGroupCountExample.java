package _11_GroupOfThread;

class Threadnews extends Thread{
	public Threadnews(String name, ThreadGroup thgr) {
		super(thgr, name);
		start();
	}
	
	public void run() {
		for (int i = 0; i < 100; i++) {
			try {
				Thread.sleep(500);;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+" thread has finished executing");
	}
}

public class ActiveGroupCountExample {
	public static void main(String[] args) {
		ThreadGroup tg = new ThreadGroup("The parent group of thread");
		
		ThreadGroup tg1 = new ThreadGroup(tg, "The child group");
		
		Threadnews th1 = new Threadnews("the fisrt", tg);
		System.out.println("Startign the first");
		
		Threadnews th2 = new Threadnews("the second", tg);
		System.out.println("Starting the second");
		
		System.out.println("Total number of active thread groups are: "+tg.activeGroupCount());
	}
}
