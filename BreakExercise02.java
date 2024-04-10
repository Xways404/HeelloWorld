import java.util.Scanner;// Scannerを使うために必要なimport文
public class BreakExercise02 {
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		
		//変量定義
		String userName = "";
		String passWord = "";
		int chance = 3;//ログインするたびに、入力機会が一回ずつなくなる。
		
		for(int i = 1; i <= 3; i++) {
			System.out.println("ユーザー名を入力");
			userName = myScanner.next();// ユーザーが入力した文字列を読み取る
			
			System.out.println("パスワードを入力");
			passWord = myScanner.next();// ユーザーが入力した整数を読み取る
			//ユーザー名とパスワードが一致するかを判断する
			//文字列の比較の使用方法は　equal
			if("田中".equals(userName) && "666".equals(passWord)) {
				System.out.println("ログイン完了しました");
				break;
			}
			//ログインの回数を減らす
			chance--;
			System.out.println("あと" +  chance + "回");
		}
	}
}