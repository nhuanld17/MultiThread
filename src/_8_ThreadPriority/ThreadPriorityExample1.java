package _8_ThreadPriority;

public class ThreadPriorityExample1 extends Thread{

	@Override
	public void run() {
		System.out.println("Inside run() methods...");
	}
	public static void main(String[] args) {
		// Set priority of main thread to 7
		Thread.currentThread().setPriority(7);
		
		System.out.println("Priority of the main thread is: "+Thread.currentThread().getPriority());
		
		ThreadPriorityExample1 th1 = new ThreadPriorityExample1();
		
		// Thread th1 are the child of the main thread
		// Therefore, the th1 thread also get the priority of 7
		
		System.out.println("Priority of thread th1: "+th1.getPriority());
	}
}
