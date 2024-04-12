package _4_SleepThread;

public class TestThreadTwice1 extends Thread{

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		TestThreadTwice1 t1 = new TestThreadTwice1();
		t1.start();
		t1.start();
	}
	
}
