import java.util.Scanner;
public class LoopTest02 {
	public static void main(String[] args) {
		
		
		Scanner myScanner = new Scanner(System.in);
		System.out.println("整数を入力");
		int num = myScanner.nextInt();
		
			if(num > 0) {
				System.out.println(num + "、は正数である");
			} else if(num < 0) {
				System.out.println(num + "、は負数である");
			} else {
				System.out.println(num + "、はゼロでござる");
			}
	}
}