public class LogicOperator01 {
	public static void main(String[] args) {
		
		//||短絡と|論理の案例
		// || 二つの条件において、一つだけでも成立すれば、結果はtrue,でなければfalse
		// |  二つの条件において、一つだけでも成立すれば、結果はtrue,でなければfalse
		int age = 50;
		if(age > 20 || age < 30) {
			System.out.println("ok199");
		}
		if(age > 20 | age < 30) {
			System.out.println("ok199");
		}
		
		//だが区別は：
		// ||短絡について、もし一つ目の条件がtrueになれば、二つ目の条件が判断せれなくなる、最終的に結果はtrue、効率が高くなる。
		// | 一方、論理について、一つ目の条件がtrueであるとしても、二つ目の条件が引き続き判断しなければならぬ。
		int a = 4;
		int b = 9;
		if(a > 1 || ++b > 4) {
			System.out.println("a=" + b + "b=" + b);
			//4,9 短絡の定義に参照すれば、++bまで進行されず、bのままに捉えられる。
		}
	}
}