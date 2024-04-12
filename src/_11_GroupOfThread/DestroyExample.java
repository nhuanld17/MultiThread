package _11_GroupOfThread;

class ABCD extends Thread{
	public ABCD(String name, ThreadGroup thgr) {
		super(thgr, name);
		start();
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+" thread has finished executing");
	}
}

public class DestroyExample {
	@SuppressWarnings("removal")
	public static void main(String[] args) throws InterruptedException {
		ThreadGroup tg = new ThreadGroup("The Parent group");
		
		ThreadGroup tg1 = new ThreadGroup(tg,"The child group");
		
		ABCD th1 = new ABCD("Fisrt", tg);
		System.out.println("Starting the first");
		
		ABCD th2 = new ABCD("Second", tg);
		System.out.println("Starting the second");
		
		th1.join();
		th2.join();
		
		tg1.destroy();
		System.out.println(tg.getName()+" is Destroyed");
		
		tg.destroy();
		System.out.println(tg.getName()+" is destroyed");
	}
}
