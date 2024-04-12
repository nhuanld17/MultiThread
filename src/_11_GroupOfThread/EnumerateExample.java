package _11_GroupOfThread;

class ThreadA extends Thread{
	public ThreadA(String name,ThreadGroup thgr) {
		// TODO Auto-generated constructor stub
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
		}
		System.out.println(Thread.currentThread().getName()+" thread has finished executing");
	}
	
}

public class EnumerateExample {
	public static void main(String[] args) {
		ThreadGroup tg = new ThreadGroup("The parent group");
		ThreadGroup tg1 = new ThreadGroup(tg,"The child group");
		
		ThreadA th1 = new ThreadA("First", tg);
		System.out.println("Starting the first");
		
		ThreadA th2 = new ThreadA("Second", tg);
		System.out.println("Starting the second");
		
		Thread[] grp = new Thread[tg.activeCount()];
		int cnt = tg.enumerate(grp);
		for (int i = 0; i < cnt; i++) {
			System.out.println("Thread "+grp[i].getName()+" is found");
		}
	}
}
