
										JAVA THREAD POOL
	
	- Java thread pool đại diện cho một nhóm các luồng công việc đang chờ công việc và được sử dụng lại  	nhiều lần.
	- Trong trường hợp của 1 thread pool, một nhóm các luồng có kích thước cố định sẽ được tạo ra. Một 			
	luồng từ thread pool được rút ra và được giao 1 nhiệm vụ. Sau khi hoàn thành công việc, luồng lại 
	được chứa trong thread pool một lần nữa.
	
									CÁC PHƯƠNG THỨC THREAD POOL
	- newFixedThreadPool(int s): tạo 1 thread pool với kích thước s
	- newCachedThreadPool():tạo ra 1 thread pool từ lớp Executators. Thread pool này có kích thước linh 
	hoạt, có thể thay đổi kích thước của mình tùy thuộc vào số lượng tác vụ cần xử lí.
	
	