package TITV;

import java.util.ArrayList;

class Buffer{
	private int capacity; // Khả năng chứa tối đa
	// Danh sách sản phẩm
	private ArrayList<Integer> products = new ArrayList<Integer>();
	
	
	
	public Buffer(int capacity) {
		super();
		this.capacity = capacity;
	}

	public void addProduct(int product, int producerID) {
		System.out.println("Nhà sản xuất "+producerID+" đã thêm sản phẩm "+product);
		products.add(product);
		System.out.println("Số lượng tồn kho: "+products.size());
	}
	
	public void removeProduct(int consumerID) {
		System.out.println("Khach hang "+consumerID+" da mua san pham "+products.get(0));
		products.remove(0);
		System.out.println("Số lượng tồn kho: "+products.size());
	}
	
	public int getSize() {
		return this.products.size();
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getCapacity() {
		return capacity;
	}
	
	
}

class Producer extends Thread{
	private int id;
	private Buffer buffer;
	public Producer(int id, Buffer buffer) {
		this.id = id;
		this.buffer = buffer;
	}
	@Override
	public void run() {
		int i = 0;
		while (true) {
			if (buffer.getCapacity() > buffer.getSize()) {
				try {
					buffer.addProduct(i++, this.id);
					sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}
}

class Consumer extends Thread{
	private int id;
	private Buffer buffer;
	public Consumer(int id, Buffer buffer) {
		this.id = id;
		this.buffer = buffer;
	}
	@Override
	public void run() {
		int i = 0;
		while (true) {
			if (buffer.getSize() > 0) {
				try {
					buffer.removeProduct(this.id);
					sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}
}

public class Bai_19 {
	public static void main(String[] args) {
		Buffer buffer = new Buffer(5);
		Producer p1 = new Producer(333, buffer);
		Consumer c1 = new Consumer(123, buffer);
		p1.start();
		c1.start();

	}
}
