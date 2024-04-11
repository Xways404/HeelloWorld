public class Return01 {
	public static void main(String[] args) {
		
//		このプログラムは、1から5までの数値を反復処理し、
//		各数値ごとに条件をチェックします。数値が3の場合、"なんかいいことないかな"とその数値を出力し、
//		その後にreturn文が実行され、プログラムが終了します。それ以外の場合、"helloworld"を出力します。
//		したがって、数値が3の場合、"helloworld"の出力は行われません。
		
		
		for(int i = 1; i <= 5; i++) { // iが1から5までの間ループを実行
			
			if(i == 3) {
				System.out.println("なんかいいことないかな" + i);
				return ;  // プログラムの実行を終了
			}
			System.out.println("helloworld");
		}
		System.out.println("go on");
	}
}