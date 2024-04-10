public class ContinueDetail {
	public static void main(String[] args) {
		
		lable1:
		for(int j = 0; j <= 4; j++) { // jが4以下の間ループを実行
			lable2:
			for(int i = 0; i < 10; i++) { // iが10未満の間ループを実行
				if(i == 2) { // もしiが2ならば
					continue lable2; // 内側のループの残りの部分をスキップし、次の繰り返しに進む
//					continue lable1; //外部ループ
				}
				System.out.println("i= " + i);
			}
		}
	}
}