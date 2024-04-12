package _8_ThreadPriority;

public class ThreadPriorityExample extends Thread{

	@Override
	public void run() {
		System.out.println("Inside the run() method");
	}
	public static void main(String[] args) {
		ThreadPriorityExample th1 = new ThreadPriorityExample();
		ThreadPriorityExample th2 = new ThreadPriorityExample();
		ThreadPriorityExample th3 = new ThreadPriorityExample();
		
		// After created, all thread have priorites of 5 by default
		System.out.println("Priority of thread th1: "+th1.getPriority());
		System.out.println("Priority of thread th2: "+th2.getPriority());
		System.out.println("Priority of thread th3: "+th3.getPriority());
		
		// Set priority 
		th1.setPriority(1);
		th2.setPriority(5);
		th3.setPriority(10);
		
		System.out.println("Priority of th1: "+th1.getPriority());
		System.out.println("Priority of th2: "+th2.getPriority());
		System.out.println("Priority of th3: "+th3.getPriority());
		
		// Main thread
		
		// Display name of the currently excuting thread
		System.out.println("Currently excuting the thread: "+Thread.currentThread().getName());
		System.out.println("Priority of the main thread: "+Thread.currentThread().getPriority());
		
		// Priority of the main thread is now
		Thread.currentThread().setPriority(10);
		
		System.out.println("Priority of the  main thread is: "+Thread.currentThread().getPriority());
	}
}
