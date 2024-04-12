package _5_CallRunMethod;

public class TestCallRun1 extends Thread{

	@Override
	public void run() {
		System.out.println("Running...");
	}
	
	public static void main(String[] args) {
		TestCallRun1 t1 = new TestCallRun1();
		t1.run(); // Fine, but does not start a seperate call stack
	}
	/*    What if we call Java run() method directly instead start() method?     */
	
	/* - Each thread starts in a separate call stack.
	 * - Invoking the run() method from the main thread, the run() method goes onto the current call       	 *	 stack rather than at the beginning of a new call stack.
	 * */
}
