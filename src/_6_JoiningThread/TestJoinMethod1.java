package _6_JoiningThread;

public class TestJoinMethod1 extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i <= 5; i++) {
			try {
				Thread.sleep(1500);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i);
		}
	}
	public static void main(String[] args) {
		TestJoinMethod1 t1 = new TestJoinMethod1();
		TestJoinMethod1 t2 = new TestJoinMethod1();
		TestJoinMethod1 t3 = new TestJoinMethod1();
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		t2.start();
		t3.start();
	}
}
