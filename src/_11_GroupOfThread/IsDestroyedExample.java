package _11_GroupOfThread;

class ThreadZ extends Thread{
	public ThreadZ(String name, ThreadGroup thgr) {
		super(thgr, name);
		start();
	}	
	
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		System.out.println(Thread.currentThread().getName()+" has finished executing");
	}
}

public class IsDestroyedExample {
	public static void main(String[] args) {
		ThreadGroup thgr = new ThreadGroup("the parent group");
		
		ThreadGroup thgr1 = new ThreadGroup(thgr, "The child group");
		
		ThreadZ th1 = new ThreadZ("The first", thgr);
		System.out.println("Starting the first");
		
		ThreadZ th2 = new ThreadZ("The second", thgr);
		System.out.println("Starting the second");
		
		if (thgr.isDestroyed()) {
			System.out.println("Destroyed");
		}else {
			System.out.println("Didn't destroys");
		}
	}
}
