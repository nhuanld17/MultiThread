package _6_JoiningThread;

class ABC extends Thread{
	Thread threadToInterrupt;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		threadToInterrupt.interrupt();
	}
}

public class ThreadJoinExample1 {
	public static void main(String[] args) {
		try {
			ABC th1 = new ABC();
			
			th1.threadToInterrupt = Thread.currentThread();
			th1.start();
			
			// invoking the join() methods leads
			// to the generation of InterroptedException
			th1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
