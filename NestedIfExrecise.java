import java.util.Scanner;
public class NestedIfExrecise {
	public static void main(String[] args) {
		
		Scanner myScanner = new Scanner(System.in);
		System.out.println("月項目を入力してください");
		int month = myScanner.nextInt();
		
		int ticketPrice = 60;
		int ticketPrice01 = 40;
		
		if(month >= 4 && month <= 10) {
			
			System.out.println("年齢を入力して");
			int age = myScanner.nextInt();
			
					if(age <= 60 && age >= 18) {
						System.out.println("大人価格は、" + ticketPrice);
					} else if(age <= 18 && age >= 1) {
						System.out.println("お子様価格は、" + ticketPrice/2);
					} else {
						System.out.println("お年寄り価格、" + ticketPrice/2);
					}
					
		} else if(month < 4 || month > 10) {
			System.out.println("年齢を入力して");
			int age = myScanner.nextInt();
			if(age <= 60 && age >= 18) {
				System.out.println("大人価格は、" + ticketPrice01);
		} else  {
			System.out.println("その他価格は、" + ticketPrice01/2);
		}
		}
	}
}