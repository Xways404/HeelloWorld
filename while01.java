public class while01 {
	public static void main(String[] args) {
		
		//”なんかいいことないかな”を十回出力する
//		int i = 1;
//		while(i <= 10) {
//			System.out.println("なんかいいことないかな" + i);
//			i++;//循環変数の反復
//		}
//		System.out.println("out" + i);
		
		int i = 40;
		int endNum = 200;
		int x = 2;
		while(i <= endNum) {
			if(i % x == 0) {
				System.out.println("i=" + i);
			}
			i++;
		}
	}
}