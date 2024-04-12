package _4_SleepThread;

public class TestSleepMethod2 {
	public static void main(String[] args) {
		try {
			for (int i = 0; i < 5; i++) {
				// The main thread sleeps for 1000 ms - 1s
				// when ever the loop runs
				Thread.sleep(1000);
				
				// Displaying the value of variable
				System.out.println(i);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
