import java.util.Scanner;
public class MulForExercise {
	public static void main(String[] args) {
		
		//三つのクラスの成績データを統計する、各クラスに５人在籍している
		//各クラスの平均点と全クラスの平均点を求め、
		//三つのクラスの合格人数を出す
		//合格人数を出す
		//
		//まず、クラスごとの学生成績を出す
		//
		
		Scanner myScanner = new Scanner(System.in);
		//総得点を定義
		double totalScore = 0;
		//合格人数
		int passNum = 0;
		//外部for、クラスごとにループ
		for(int cla = 1; cla <= 3; cla++) {
			//クラスごとの合計点を定義
			double sum = 0;
			//内部for、各クラスの各学生の点数入力
			 for(int stu = 1; stu <= 5; stu++) {
				 System.out.println(+ cla + "クラスの" + stu + "番目の学生の成績を入力");
				 double score = myScanner.nextDouble();
				 //６０点以上になれば合格
				 if(score >= 60) {
					 passNum++;
				 }
				 sum += score;//各生徒の成績の累計
				 System.out.println("成績は" + score);
			 } 
			 //クラス全生徒の成績を集計し、人数分で割って、平均を出す。
			System.out.println("平均点は" + (sum/5));
			//各生徒の成績の累計を全生徒の中に導入し、さらに累計する
			totalScore += sum;
		}
		//学年の総得点を出して、平均点を出す
		System.out.println("全クラスの平均は" + totalScore / 15);
		//合格人数を出す
		System.out.println("合格人数は" + passNum);
	}
}