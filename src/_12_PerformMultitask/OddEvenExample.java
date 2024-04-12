package _12_PerformMultitask;

public class OddEvenExample {
	int contr = 1;
	static int NUM;
	
	/*
	 * - Cách thức hoạt động:
	 * + Có 2 luồng,1 luồng in số lẻ từ 1 đến NUM, 1 luồng in số chẵn từ 1 đến NUM
	 * + Luồng số chẵn chạy trước, khi đó contr = 1 không thỏa mãn-> gọi wait() để
	 * chờ luồng tạo số lẻ chạy.
	 * + Luồng số lẻ gặp contr = 1 (thỏa mãn)--> in ra màn hình, contr ++ = 2 (Không thỏa)
	 * --> gọi notify() để đánh thức luồng đang đợi ( luồng in số chẵn )
	 * + Tiếp tục luân phiên, ta được 1 dãy số từ 1 đến NUM 
	 */
	
	public synchronized void displayOddNumber() {
		// Printing the numbers till Num
		while (contr < NUM) {
			while (contr % 2 == 0) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(contr+" ");
			contr++;
			notify();
		}
	}
	
	public synchronized void displayEvenNumber() {
		while (contr < NUM) {
			while (contr % 2 == 1) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(contr+" ");
			contr++;
			notify();
		}
	}
	public static void main(String[] args) {
		NUM = 20;
		
		OddEvenExample oddEvenExample = new OddEvenExample();
		Thread th1 = new Thread(() -> {
			oddEvenExample.displayEvenNumber();
		});
		Thread th2 = new Thread(() -> {
			oddEvenExample.displayOddNumber();
		});
		th2.start();
		th1.start();
	}
	/*
	 * - synchronized: được sử dụng để đảm bảo chỉ có 1 luồng có thể truy cập vào 1 phương thức
	 * hoặc 1 khối mã cùng 1 lúc. Khi 1 luồng đã bắt đầu thực thi một phương thức hoặc 1 khối mã
	 * được đánh dấu synchronized, nó sẽ chiếm giữ khóa của đối tượng hoặc của lớp và không cho
	 * phép các luồng khác truy cập vào đối tượng hoặc khối mã synchronized đó cho đến khi luồng
	 * đó đã hoàn thành.
	 * - Trong đoạn code, synchronized được sử dụng để đảm bảo rằng chỉ có 1 luồng có thể truy cập
	 * vào phương thức displayOddNumber() hoặc displayEvenNumber() cùng 1 lúc. Điều này giúp
	 * đảm bảo rằng các số lẻ hoặc các số chẵn được in ra theo thứ tự đúng và không bị xáo trộn
	 * 
	 * - Nếu không sử dụng từ khóa synchronized, có thể xảy ra hiện tượng cạnh tranh (race condition) 	  	 * khi hai hoặc nhiều luồng cố gắng thực thi cùng một phương thức hoặc khối mã cùng một lúc. Kết
	 *  quả có thể là số không được in ra theo thứ tự mong muốn hoặc các vấn đề khác liên quan đến 
	 *  đồng bộ hóa.
	 */
}
