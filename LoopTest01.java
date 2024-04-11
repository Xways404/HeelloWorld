public class LoopTest01 {
	public static void main(String[] args) {
		
		//初期設定」
		double money = 100000; //所持金
		int count = 0; //通過回数をカウント
		
		//無限ループ
		while(true) {
			//もしもの条件を立ち上げ
			if(money > 50000) {
				money = money - money * 0.05;//通過たび、手数料5％ひかれる
				count++;//通過回数をカウント
				
			} else if (money >= 1000) { 
				money -= 1000; //通過たび、1000円ひかれる
				count++; //通過回数をカウント
				
			} else { //1000円未満
				break; //ループを終了する
			}
		}
		System.out.println("100000円は、" + count + "回通過できる");
	}
}