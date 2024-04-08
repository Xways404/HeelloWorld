public class BinOperator02 {
	public static void main(String[] arga) {
		
		//２進数　00000001 割る２にする 00000000
		int a = 1 >> 2;
		System.out.println(a);
		//２進数　00000001 かけ２にする 00000100 
		int b = 1 << 2;
		System.out.println(b);
		//２進数　00000100 かけ２にする　00100000
		int c = 4 << 3;
		System.out.println(c);
		
		
	}
}