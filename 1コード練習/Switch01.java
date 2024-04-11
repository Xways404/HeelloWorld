import java.util.Scanner;

public class Switch01 {
	public static void main(String[] args) {
		
		Scanner myScanner = new Scanner(System.in);
		System.out.println("曜日データ(a-g)を入力");
		char c1 = myScanner.next().charAt(0);
		
		switch(c1) {
			case 'a' :
				System.out.println("月曜日");
				break;
			case 'b' :
				System.out.println("火曜日");
				break;
			case 'c' :
				System.out.println("水曜日");
				break;
			case 'd' :
				System.out.println("木曜日");
				break;
			case 'e' :
				System.out.println("金曜日");
				break;
			case 'f' :
				System.out.println("土曜日");
				break;
			case 'g' :
				System.out.println("日曜日");
				break;
			default:
				System.out.println("あなたの入力したデータがエラー発生");
		}
		System.out.println("Switchから退出し、プロミングを継続");
		
	}
}