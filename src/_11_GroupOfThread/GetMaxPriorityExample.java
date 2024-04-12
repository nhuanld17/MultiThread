package _11_GroupOfThread;

class ThreadA1 extends Thread{
	public ThreadA1(String name, ThreadGroup thgr) {
		// TODO Auto-generated constructor stub
		super(thgr, name);
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

public class GetMaxPriorityExample {
	public static void main(String[] args) {
		ThreadGroup thgr = new ThreadGroup("The parent group");
		
		ThreadGroup thgr1 = new ThreadGroup(thgr,"The child group");
		
		ThreadA1 th1 = new ThreadA1("The first", thgr1);
		System.out.println("Starting the fisrt");
		
		ThreadA1 th2 = new ThreadA1("The second", thgr1);
		System.out.println("Starting the second");
		
		int priority = thgr.getMaxPriority();
		
		System.out.println("The maximum priority of the parent ThreadGroup: "+priority);
	}
}
