import java.util.Scanner;
public class If03 {
	public static void main(String[] args) {
		/*
		田中さんの借入信用度を入力する：
		もし、
		借入信用度が１００点のとき、「高質信用」
		８０から９９点の間は、「上質信用」
		６０から８０点の間は、「一般信用」
		その他の場合は、「無信用」
		*/		
		
		Scanner myScanner = new Scanner(System.in);
		System.out.println("信用度入力欄");
		int grade = myScanner.nextInt();
		//まず、有効なデータを入手するために、データの範囲を決めておく
		//１から１００までの数値に制限を掛ける
		
		//ダブルIFを利用して制限をかける
		
		if(grade >=1 && grade <= 100) {
			
			if(grade == 100) {
				System.out.println("高質信用");
			} else if (grade > 80 && grade <= 99) {
				System.out.println("上質信用");
			} else if (grade >= 60 && grade <= 80) {
				System.out.println("一般信用");
			} else {
				System.out.println("無信用　");
			}
		} else { 
			System.out.println("数値オーバーエラー");
		}
	}
}