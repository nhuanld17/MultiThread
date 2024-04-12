package _5_CallRunMethod;

public class TestCallRun2 extends Thread{

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		TestCallRun2 t1 = new TestCallRun2();
		TestCallRun2 t2 = new TestCallRun2();
		
		t1.run();
		t2.run();
		
		/* - Output: 0 1 2 3 4 0 1 2 3 4
		 * - không có sự luận phiên trong việc thực thi 2 luồng, thay vào đó, luồng 1
		 * sẽ được thực thi trước, sau đó đến t2
		 * - Khi gọi run(), t1 và t2 được coi là đối tượng bình thường, không phải đối tượng
		 * luồng
		 */
	}
}
