import java.util.Scanner;
public class SwitchExercise {
	public static void main(String[] args) {
		//switchを使って、アルファベットの小文字を
		//char型で大文字に変換
		//その他のものを”other”として出力する
		
//		Scanner myScanner = new Scanner(System.in);
//		System.out.println("aからeまでのデータを入力");
//		char c1 = myScanner.next().charAt(0);
//		switch(c1) {
//			case 'a' :
//				System.out.println("A");
//				break;
//			case 'b' :
//				System.out.println("B");
//				break;
//			case 'c' :
//				System.out.println("C");
//				break;
//			case 'd' :
//				System.out.println("D");
//				break;
//			case 'e' :
//				System.out.println("E");
//			default :
//				System.out.println("入力エラー");
//		}
		//学生の成績に対して、６０点以上であれば、””合格”を出力する
		//以下の場合は”不合格”を出力。条件：１００点満点とする。
		//強制変換を運用する
		//成績が６０から１００点の間であれば、（int）（成績/６０）＝　１
		//成績が０から６０点の間であれば、（int）（成績/６０）＝　０
		//これぞ！プログラミング思考ではないか！！
		
//			double score = 88.5;
//			
//		if(score >= 0 && score <= 100) {
//			switch ((int)(score / 60)) {
//			case 0:
//				System.out.println("不合格");
//				break;
//			case 1:
//				System.out.println("合格");
//				break;
//			default :
//				System.out.println("入力エラー");
//			}
//		} else {
//			System.out.println("点数入力は０から１００点までにする");
//		}
		//指定された「月」に、その「月」の季節をプリントアウトする
		//３、４、５月は「春」、６、７、８月は「夏」、９、１０、１１月は「秋」、１２、１、２「冬」
		
		Scanner myScanner = new Scanner(System.in);
		System.out.println("月入力");
		int month = myScanner.nextInt();
		switch(month) {
			case 3:
			case 4:
			case 5:
				System.out.println("春ですね");
				break;
			case 6:
			case 7:
			case 8:
				System.out.println("夏ですね");
				break;
			case 9:
			case 10:
			case 11:
				System.out.println("秋ですね");
				break;
			case 12:
			case 1:
			case 2:
				System.out.println("冬ですね");
				break;
			default:
				System.out.println("正しいデータを入力して");
		
		}
		
	}
}