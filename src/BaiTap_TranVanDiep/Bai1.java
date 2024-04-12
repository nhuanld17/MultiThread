package BaiTap_TranVanDiep;

import java.util.Random;

class ShareData{
	int rad;
	
	public ShareData() {
		// TODO Auto-generated constructor stub
	}

	public int getRad() {
		return rad;
	}

	public void setRad(int rad) {
		this.rad = rad;
	}
	
}

class ThreadRandom extends Thread{
	ShareData shareData;

	public ThreadRandom(ShareData shareData) {
		this.shareData = shareData;
	}
	
	@Override
	public void run() {
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			synchronized (shareData) { // Chạy đồng bộ trên đối tượng shareData
				int rad = random.nextInt(100) + 1; // Sinh số ngẫu nhiên từ 1 đến 100
				shareData.setRad(rad); // Lưu giá trị số ngẫu nhiên vào shareData
				System.out.println("Rad: "+ rad); // In ra giá trị số ngẫu nhiên
				
				shareData.notifyAll(); // Thông báo cho các luồng đang đợi rằng dữ liệu đã sẵn sàng
				try {
					shareData.wait(); // Chờ phản hồi từ luồng khác
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

class ThreadSquare extends Thread{
	ShareData shareData;

	public ThreadSquare(ShareData shareData) {
		this.shareData = shareData;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			synchronized (shareData) { // Chạy đồng bộ trên đối tượng shareData
				try {
					shareData.notifyAll(); // Thông báo cho các luồng đang đợi rằng dữ liệu đã sẵn sàng
					shareData.wait(); // Chờ phản hồi từ luồng khác
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				int rad = shareData.getRad(); // Lấy giá trị số từ shareData
				rad *= rad; // Tính bình phương của giá trị số
				System.out.println("PT: "+ rad); // In ra bình phương của giá trị số

			}
		}
	}
	
}

public class Bai1 {
	public static void main(String[] args) {
		ShareData shareData = new ShareData(); // Tạo đối tượng shareData
		
		ThreadRandom threadRandom = new ThreadRandom(shareData); // Tạo luồng ThreadRandom và truyền vào shareData
		ThreadSquare threadSquare = new ThreadSquare(shareData); // Tạo luồng ThreadSquare và truyền vào shareData
		
		threadRandom.start(); // Khởi động luồng ThreadRandom
		threadSquare.start(); // Khởi động luồng ThreadSquare
	}
}
