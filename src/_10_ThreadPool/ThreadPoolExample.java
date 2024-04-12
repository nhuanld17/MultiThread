package _10_ThreadPool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task implements Runnable{
	private String taskName;

	public Task(String taskName) {
		this.taskName = taskName;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 5; i++) {
				if(i == 0) {
					Date dt = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
					System.out.println("Initialization time for the task name: "+taskName+" = "+sdf.format(dt));
				}else {
					Date dt = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
					
					System.out.println("Time of execution for the task name: "+taskName+" = "+sdf.format(dt));
				}
				
				Thread.sleep(1000);
			}
			System.out.println(taskName+" is complete");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class ThreadPoolExample {
	static final int MAX_TH = 3;
	
	public static void main(String[] args) {
		Runnable runnable1 = new Task("Task1");
		Runnable runnable2 = new Task("Task2");
		Runnable runnable3 = new Task("Task3");
		Runnable runnable4 = new Task("Task4");
		Runnable runnable5 = new Task("Task5");
		
		// Tạo 1 thread pool với kích thước là 3 luồng
		ExecutorService pool = Executors.newFixedThreadPool(MAX_TH);
		
		// Thực thi các luồng
		pool.execute(runnable1);
		pool.execute(runnable2);
		pool.execute(runnable3);
		pool.execute(runnable4);
		pool.execute(runnable5);
		
		/*
		 * - Khi thực thi các luồng từ runnable1 đến runnable5, vì kích thước của nhóm luồng 
		 *  là 3 nên các luồng từ runnable1 đến runnable3 sẽ được thực thi trước
		 * - Sau khi 3 luồng đầu được thực thi xong, 2 luồng còn lại sẽ được thực thi
		 * 
		 */
		
		
		pool.shutdown();
	}
}
