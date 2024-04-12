package BaiTap_TranVanDiep;

import java.util.Random;

class SharedData {
	int rad;
	int total;
	// index = 1, 2, 3
	// 1 => Thread 1
	// 2 => Thread 2
	// 3 => Thread 3
	int index;

	public SharedData() {
		total = 0;
		index = 1;
	}

	public int getRad() {
		return rad;
	}

	public void setRad(int rad) {
		this.rad = rad;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public synchronized void plus(int value) {
		total += value;
	}

	public synchronized boolean checkAvaiable() {
		return total < 2000;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}

class Thread1 extends Thread {
	SharedData sharedData;

	public Thread1(SharedData sharedData) {
		this.sharedData = sharedData;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}

		Random random = new Random();

		while (sharedData.checkAvaiable()) {
			synchronized (sharedData) {
				int rad = random.nextInt(100) + 1;
				sharedData.setRad(rad);
				sharedData.plus(rad);
				System.out.println("T1 >> " + rad);

				// thiet lap luong tiep theo dc phep chay
				if (rad % 3 == 0) {
					sharedData.setIndex(2);
				} else {
					sharedData.setIndex(3);
				}

				// sync thread
				sharedData.notifyAll();
				try {
					sharedData.wait();
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			}
		}
		System.out.println("T1 Stop");
		synchronized (sharedData) {
			sharedData.notifyAll();
		}
	}
}

class Thread2 extends Thread {
	SharedData sharedData;

	public Thread2(SharedData sharedData) {
		this.sharedData = sharedData;
	}

	@Override
	public void run() {
		while (sharedData.checkAvaiable()) {
			synchronized (sharedData) {
				sharedData.notifyAll();
				try {
					while (sharedData.getIndex() != 2 && sharedData.checkAvaiable()) {
						sharedData.wait();
					}
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}

				int rad = sharedData.getRad();
				if (rad % 3 == 0) {
					rad *= rad;
					System.out.println("T2 >> " + rad);
				}

				sharedData.setIndex(1);
			}
		}
		System.out.println("T2 Stop");
		synchronized (sharedData) {
			sharedData.notifyAll();
		}
	}
}

class Thread3 extends Thread {
	SharedData sharedData;

	public Thread3(SharedData sharedData) {
		this.sharedData = sharedData;
	}

	@Override
	public void run() {
		while (sharedData.checkAvaiable()) {
			synchronized (sharedData) {
				sharedData.notifyAll();
				try {
					while (sharedData.getIndex() != 3 && sharedData.checkAvaiable()) {
						sharedData.wait();
					}
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}

				int rad = sharedData.getRad();
				if (rad % 2 == 0) {
					if (rad % 4 == 0) {
						System.out.println("So ngau nhien chia het cho 4");
					} else {
						System.out.println("So ngau nhieu ko chia het cho 4");
					}
				} else {
					System.out.println("Ko le");
				}
				sharedData.setIndex(1);
			}
		}
		System.out.println("T3 Stop");
		synchronized (sharedData) {
			sharedData.notifyAll();
		}
	}
}

public class Bai2 {
	public static void main(String[] args) {
		SharedData sharedData = new SharedData();

		Thread1 thread1 = new Thread1(sharedData);
		Thread2 thread2 = new Thread2(sharedData);
		Thread3 thread3 = new Thread3(sharedData);

		thread1.start();
		thread2.start();
		thread3.start();
	}
}
