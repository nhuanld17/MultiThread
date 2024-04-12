package _4_SleepThread;

public class TestSleepMethod3 {
	public static void main(String[] args) {
		try {
			for (int i = 0; i < 5; i++) {
				// it throw the exception IllegalArgumentException
				// as time is negative which is -100
				Thread.sleep(-100);
				
				System.out.println(i);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
