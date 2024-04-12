package _11_GroupOfThread;

class ThreadD extends Thread{
	public ThreadD(String name, ThreadGroup threadGroup) {
		super(threadGroup, name);
		start();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; i++) {
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+" has finished executing");
	}
}

public class IsDaemonExample {
	public static void main(String[] args) {
		ThreadGroup thgr = new ThreadGroup("The parent group");
		
		ThreadGroup thgr1 = new ThreadGroup(thgr, "The child groups");
		
		ThreadD th1 = new ThreadD("The first", thgr);
		System.out.println("Starting the first");
		
		ThreadD th2 = new ThreadD("The second", thgr);
		System.out.println("Starting the second");
		
		if (thgr.isDaemon()) {
			System.out.println("The group is a daemon group	");
		}else {
			System.out.println("The group is not a daemon group ");
		}
	}
}
