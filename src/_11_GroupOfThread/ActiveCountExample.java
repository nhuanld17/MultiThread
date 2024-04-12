package _11_GroupOfThread;

class ThreadNew extends Thread{
	public ThreadNew(String name, ThreadGroup thgr) {
		super(thgr,name);
		start();
	}
	public void run() {
		for (int i = 0; i < 1000; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class ActiveCountExample {
	public static void main(String[] args) {
		ThreadGroup tg = new ThreadGroup("The parent group of threads");
		
		ThreadNew th1 = new ThreadNew("first", tg);
		System.out.println("Starting the first");
		
		ThreadNew th2 = new ThreadNew("second", tg);
		System.out.println("Starting the second");
		
		System.out.println("The total number of active threads are: "+tg.activeCount());
	}
}
