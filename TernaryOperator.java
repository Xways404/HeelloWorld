//三項演算子
public class TernaryOperator {
	public static void main(String[] args) {
		
		int a = 10;
		int b = 99;
		//if a>b is ture >a++, false >b--
		int result = a < b? a++ : b--;
		System.out.println("result=" + result);
		System.out.println("a=" + a);
		System.out.println("b=" + b);
		
	}
}
