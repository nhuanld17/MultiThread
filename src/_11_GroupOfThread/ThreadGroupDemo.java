package _11_GroupOfThread;

public class ThreadGroupDemo implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName());
	}
	public static void main(String[] args) {
		ThreadGroupDemo runnable = new ThreadGroupDemo();
		
		ThreadGroup thgr1 = new ThreadGroup("Parent ThreadGroup");
		
		Thread th1 = new Thread(thgr1,runnable,"one");
		th1.start();
		Thread th2 = new Thread(thgr1,runnable,"two");
		th2.start();
		Thread th3 = new Thread(thgr1,runnable,"three");
		th3.start();
		
		System.out.println("Thread Group Name:"+thgr1.getName());
		thgr1.list();//Prints information about this thread group to the standardoutput. This method is useful only for debugging.

	}
}
