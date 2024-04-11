import java.util.Scanner;

public class NestedIf {
	public static void main(String[] args) {
		
		/*
		ミュージックコンテスト、初戦の成績が８.０より大きいければ、決戦組に突入、
		出なければアウト。
		性別ごとに男女組へ入れ分ける
		*/
		
		Scanner myScanner = new Scanner(System.in);
		System.out.println("歌手の成績入力欄");
		double score = myScanner.nextDouble();
		
		if(score >= 0.1 && score <= 10.0) {
			
			if(score > 8.0) {
				System.out.println("性別入力欄");
				char gender = myScanner.next().charAt(0);
				if(gender == '男') {
					System.out.println("男性組へ");
				} else if(gender == '女') {
					System.out.println("女性組へ");
				} else {
					System.out.println("正しい性別情報を入力");
				}
			} else {
				System.out.println("残念、アウトですね");
			}
		} else {
			System.out.println("スコアエラー");
		}
	}
}