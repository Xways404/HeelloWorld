public class LogicOperator {
	public static void main(String[] args) {
		//&&,&
		int age = 50;
		if(age > 20 && age < 90) {
			System.out.println("ok100");
		}
		
		if(age > 20 & age < 90) {
			System.out.println("ok200");
		}
		
		//違い＆、＆＆
		int a = 4;
		int b = 9;
		// && 短絡に関して、最初の条件が false の場合、後続の条件が判断されない。
		// & 論理積に関して、最初の条件が false の場合でも、後続の条件は判断される。
		if(a < 10 && ++b < 50) {
			System.out.println("ok300");
		}
		System.out.println("a=" + a + "b=" + b);//4,9
	}
}