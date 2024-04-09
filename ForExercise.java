public class ForExercise {
	public static void main(String[] args) {
		 
		//1から１００まで間の９の倍数の数値を全てプリントアウトする、個数と総和を統計する
		//複雑な需要を簡潔な需要に取り壊して、ステップごとに完成する
		//先に固定な数値として考え、次に変換しやすい数値に転換
		
		//１から１００までの数値を出力
		//輸出する際に、選別し、９の倍数のみ出力する。i % 9 == 0
		//個数を統計し、変量を定義する int count = 0;条件が満たした場合　count++;
		//総和、変量を定義する int sum = 0;　条件が満たした場合　sum += 1;
		//需要を柔軟に対応するためには、範囲の数値を変量に切り替える。
		//９も変量にできる
		
		int count = 0;//９の倍数
		int sum = 0;//総和
		int start = 1;
		int end = 100;
		int x = 8;
		for(int i = start; i <= end; i++) {
			if(i % x == 0) {
			System.out.println("i=" + i);
			count++;
			sum += i;//累計
			}
		}
		System.out.println("count=" + count);
		System.out.println("sum=" + sum);
	}
}