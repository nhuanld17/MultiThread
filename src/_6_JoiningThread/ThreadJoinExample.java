package _6_JoiningThread;

class ThreadJoin extends Thread{

	@Override
	public void run() {
		for (int i = 0; i < 2; i++) {
			try {
				Thread.sleep(300);
				System.out.println("The current thread name is: "+Thread.currentThread().getName());
			} catch (InterruptedException e) {
				System.out.println("The exception has been caught: "+e);
			}
			System.out.println(i);
		}
	}
	
}

public class ThreadJoinExample {
	public static void main(String[] args) {
		ThreadJoin t1 = new ThreadJoin();
		ThreadJoin t2 = new ThreadJoin();
		ThreadJoin t3 = new ThreadJoin();
		
		//thread th1 start
		t1.start();
		
		
		// Starting the second thread after when the first thread t1 has ended or died
		try {
			System.out.println("The current thread name is: "+Thread.currentThread().getName());
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// thread t2 starts
		t2.start();
		
		// starting the th3 thread after when the thread th2 has ended or died.  
		try {
			System.out.println("The current thread name is: "+Thread.currentThread().getName());
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Thread t3 starts
		t3.start();
	}
}
