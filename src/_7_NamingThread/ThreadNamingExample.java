package _7_NamingThread;

class ThreadName extends Thread{
	public ThreadName(String threadName) {
		// Invoking the contructor of super class, which is Thread class
		super(threadName);
	}

	@Override
	public void run() {
		System.out.println("The thread is excuting...");
	}
}

public class ThreadNamingExample {
	public static void main(String[] args) {
		ThreadName th1 = new ThreadName("Th1");
		ThreadName th2 = new ThreadName("Th2");
		
		//invoking the getName() methods to get the names of the thread created above
		System.out.println("Thread-1:"+th1.getName());
		System.out.println("Thread-2:"+th2.getName());
		
		th1.start();
		th2.start();
	}
}
