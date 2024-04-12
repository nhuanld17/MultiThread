package _4_SleepThread;

public class TestSleepMethod1 extends Thread {
	public void run() {
		for (int i = 1; i < 5; i++) {
			// The thread will sleep for the 500 ms
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		TestSleepMethod1 t1 = new TestSleepMethod1();
		TestSleepMethod1 t2 = new TestSleepMethod1();

		t1.start();
		t2.start();

		/*
		 * - Output: 1 1 2 2 3 3 4 4
		 * - Tại 1 thời điểm, chỉ có 1 luồng được thực thi. Nếu cho 1 luồng ngủ trong
		 * 	 1 khoảng thời gian, bộ lập lịch luồng sẽ chọn một luồng khác
		 * - Trong đoạn code trên, t1 chạy trước t2, sau khi t1 in ra 1 và ngủ
		 * 	 thì t2 sẽ in ra 1 và ngủ,... cho đến khi kết thúc luồng
		 */
	}
}
