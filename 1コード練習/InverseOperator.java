public class InverseOperator {
	public static void main(String[] args) {
		
		//論理否定！！！！！右辺
		System.out.println(20 < 60);
		System.out.println(!(20 < 60));

		// a^b: 論理的排他的論理和演算子であり、a と b が異なる場合、
		//      結果は true となり、そうでない場合、結果は false となる。

		boolean b = (10 > 1) ^ (3 < 5);
		System.out.println("b=" + b);//false
		
		
	}
}