public class TernaryOperatorDetail {
	public static void main (String[] args) {
		int a = 3;
		int b = 8;
//		int c = a > b ? a : b; //ok
//		int c = a > b ? 1.1 :3.4; //no
		int c = a > b ? (int)1.1 : (int)3.4;
		System.out.println("c=" + c);
		
		int n1 = 55;
		int n2 = 33;
		int n3 = 123;
		
		int max1 = n1 > n2 ? n1 : n2;
		int max2 = max1 > n3 ? max1 : n3;
		System.out.println("Max=" + max2);
		
		int max = (n1 > n2 ? n1 : n2) > n3 ? (n1 > n2 ? n1 : n2) : n3;
		System.out.println(max);
		
		
		
		
	}
}