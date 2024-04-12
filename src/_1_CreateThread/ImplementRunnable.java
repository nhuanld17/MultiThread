package _1_CreateThread;

public class ImplementRunnable implements Runnable{

	@Override
	public void run() {
		System.out.println("Thread is running....");
	}
	public static void main(String[] args) {
		ImplementRunnable m1 = new ImplementRunnable();
		Thread t1 = new Thread(m1); // Using constructor Thread(Runnable r)
		t1.start();
		System.out.println("Name of thread: "+t1.getName());
	}
}
