import java.util.Scanner;
public class input {
	public static void main(String[] args) {
		
		Scanner myScanner = new Scanner(System.in);
		
		System.out.println("名前入力");
		String name = myScanner.next();
		
		System.out.println("年齢");
		int age = myScanner.nextInt();
		
		System.out.println("給料入力");
		double sal = myScanner.nextDouble();
		
		System.out.println("データ");
		System.out.println("名前 " + name + "年齢 " + age + "給料 " + sal);
	}
}