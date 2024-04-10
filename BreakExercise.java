public class BreakExercise {
	public static void main(String[] args) {
		//１から１００以内の数値から和を求め、和が２０より大きい数値を求める
		//ローグイン登録を認証するシステム、チャンスは三回として、IDが”田中”、
		//パスワードが”666”になっていればアクセス成功を示し、不成功の場合は
		//あよ何回でチャンスがなくなるのを提示する、
		
		int sum =0;
		int n = 0; 
		for(int i = 1; i <= 100; i++) {
			sum += i;
			if(sum > 20) {
				System.out.println("和＞２０の時、i=" + i);
				n = i;
				break;
			}
		}
		System.out.println(n);
	}
}