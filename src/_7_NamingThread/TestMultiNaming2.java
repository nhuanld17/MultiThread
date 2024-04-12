package _7_NamingThread;

public class TestMultiNaming2 extends Thread{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
	public static void main(String[] args) {
		TestMultiNaming2 t1 = new TestMultiNaming2();
		TestMultiNaming2 t2 = new TestMultiNaming2();
		
		t1.start();
		t2.start();
	}
}
