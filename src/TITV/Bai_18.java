package TITV;

class TaskA extends Thread{

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println("AAAAAAAAAAA");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}


class TaskB implements Runnable {
	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println("BBBBBBBBBBBB");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class Bai_18{	
	public static void main(String[] args) {
		System.out.println("Main");
		Thread th = new TaskA();
		th.start();
		
		Thread th2 = new Thread(new TaskB());
		th2.start();
		
		System.out.println("End main");
	}
}
