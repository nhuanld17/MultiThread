package _2_ThreadState;

class ABC implements Runnable{

	@Override
	public void run() {
		try {
			// Moving thread t2 to the state timed waiting 
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("The state of thread 1 while it invoked the method join() on thread t2 "+ThreadState.t1.getState());
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

public class ThreadState implements Runnable{
	public static Thread t1;
	public static ThreadState obj;
	
	
	public static void main(String[] args) {
		obj = new ThreadState();
		t1 = new Thread(obj);
		
		//Thread 1 is spawned
		//The thread 1 is currently in the NEW state
		System.out.println("The state of thread t1 after spawning it- "+t1.getState());
		
		// invoking the start() method on t1
		t1.start();
		
		System.out.println("The state of thread t1 after invoking the method start()-"+t1.getState());
		
		
	}


	@Override
	public void run() {
		ABC myobj = new ABC();
		Thread t2 = new Thread(myobj);
		
		// Thread t2 is created and currently in the NEW state
		System.out.println("The state of thread t2 after spawning it-"+t2.getState());
		
		t2.start();
		System.out.println("The state of thread t2 after calling the method start on it - "+t2.getState());
		
		// Try-catch block for the smooth flow of the program
		try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("The state of thread t2 when it has complete its excution - "+t2.getState());
	}
	
}
