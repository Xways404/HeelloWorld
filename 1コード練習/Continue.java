public class Continue {
	public static void main(String[] aegs) {
		int i = 1;
		while(i <= 4) { // iが4以下の間ループを実行する
			i++; // iをインクリメントする
			if(i == 2) { // もしiが2ならば
				continue; // ループの残りの部分をスキップし、次の繰り返しに進みます
			}
			System.out.println("i=  " + i);
		}
	}
}