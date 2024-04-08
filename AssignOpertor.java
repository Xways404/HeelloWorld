public class AssignOpertor {
	public static void main(String[] args) {
		
		int n1 = 10;
		n1 += 4;//n1=n1+4
		System.out.println(n1);//14
		
		n1 /=3;//n1=n1/3
		System.out.println(n1);//4
		
		//複合代入演算子は強制的に型の変換が行われる
		byte b = 3;
		b += 2;//b = (byte)(b + 2);
		System.out.println(b);
		
	}
}