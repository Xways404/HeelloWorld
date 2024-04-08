import java.util.Scanner;
	
public class If01 {
	public static void main(String[] args) {
		
		//ある人物の年齢を入力するプログラミングを編集する、
		//もし、その人物の名前が１８歳以上であれば、
		//”あなたの年齢が１８歳以上である場合、其方が犯した行為に責任を取らなければならないため、監獄に入れ込む。”と出力する。
		
		//年齢を入力するために、Scannerを定義して、データを受け取る
		//年齢を変数（int　age）に保存する
		//ifを使用して判断し、応じたデータを出力する。
		
		Scanner myScanner = new Scanner(System.in);
		System.out.println("年齢を入力");
		int age = myScanner.nextInt();
		if(age > 18) {
			System.out.println("あなたの年齢が１８歳以上である場合、其方が犯した行為に責任を取らなければならないため、監獄に入れ込む。");
		}
		System.out.println("プロミング継続");
	}
}