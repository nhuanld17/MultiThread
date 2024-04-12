package _1_CreateThread;

public class ExtendThread extends Thread{

	@Override
	public void run() {
		System.out.println("Thread is running...");
	}
	public static void main(String[] args) {
		ExtendThread extendThread = new ExtendThread();
		extendThread.start();
	}
}
