package _9_DeamonThread;

public class TestDaemonThread1 extends Thread{

	@Override
	public void run() {
		if (Thread.currentThread().isDaemon()) {// Checking for daemon thread
			System.out.println("Daemon thread work");
		}else {
			System.out.println("User thread work");
		}
	}
	public static void main(String[] args) {
		TestDaemonThread1 t1 = new TestDaemonThread1();
		TestDaemonThread1 t2 = new TestDaemonThread1();
		TestDaemonThread1 t3 = new TestDaemonThread1();
		
		t1.setDaemon(true);
		
		t1.start();
		t2.start();
		t3.start();
	}
}
