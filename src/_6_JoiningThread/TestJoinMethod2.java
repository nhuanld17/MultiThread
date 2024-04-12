package _6_JoiningThread;

public class TestJoinMethod2 extends Thread{

	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i);
		}
	}
	public static void main(String[] args) {
		TestJoinMethod2 th1 = new TestJoinMethod2();
		TestJoinMethod2 th2 = new TestJoinMethod2();
		TestJoinMethod2 th3 = new TestJoinMethod2();
		th1.start();
		
		try {
			th1.join(1500);
			// Khi t1 chạy được 1500 ms ( 3 lần) t2 và t3 bắt đầu thực thi
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		th2.start();
		th3.start();
	}
}
