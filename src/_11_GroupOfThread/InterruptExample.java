package _11_GroupOfThread;

class ThreadC extends Thread{
	public ThreadC(String name, ThreadGroup thgr) {
		super(thgr, name);
		start();
	}
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+" has finished executing");
	}
}

public class InterruptExample {
	public static void main(String[] args) {
		ThreadGroup thgr = new ThreadGroup("The parent group");
		
		ThreadGroup thgr1 = new ThreadGroup(thgr, "The child group");
		
		ThreadC th1 = new ThreadC("The first", thgr);
		System.out.println("Starting the first");
		
		ThreadC th2 = new ThreadC("The second", thgr);
		System.out.println("Starting the second");
		
		thgr.interrupt();
	}
}
