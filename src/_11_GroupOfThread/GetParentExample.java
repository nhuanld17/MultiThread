package _11_GroupOfThread;

class ThreadB extends Thread{
	public ThreadB(String name, ThreadGroup thgr) {
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
		System.out.println(Thread.currentThread().getName()+" has finised executing");
	}
	
	
}

public class GetParentExample {
	public static void main(String[] args) {
		ThreadGroup thgr = new ThreadGroup("The parent group");
		ThreadGroup thgr1 = new ThreadGroup(thgr, "The child group");
		
		ThreadB th1 = new ThreadB("The first", thgr);
		System.out.println("Starting the first");
		
		ThreadB th2 = new ThreadB("The second", thgr);
		System.out.println("Starting the second");
		
		System.out.println("The ParentThreadGroup for "+thgr.getName()+" is "+thgr.getParent().getName());
		System.out.println("The ParentThreadGroup for "+thgr1.getName()+" is "+thgr1.getParent().getName());
	}
}
