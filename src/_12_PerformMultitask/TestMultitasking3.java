package _12_PerformMultitask;

class Simple1 extends Thread{
	@Override
	public void run() {
		System.out.println("Task one");
	}
}

class Simple2 extends Thread{
	@Override
	public void run() {
		System.out.println("Task two");
	}
}

public class TestMultitasking3 {
	public static void main(String[] args) {
		Simple1 t1 = new Simple1();
		Simple2 t2 = new Simple2();
		
		t1.start();
		t2.start();
	}
}
