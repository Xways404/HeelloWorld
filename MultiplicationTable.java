//public class MultiplicationTable {
//	public static void main(String[] args) {
//		
//		for (int i = 1; i <= 9; i++) {
//			for (int j = 1; j <= i; j++) {
//				System.out.println(j + "x" + i + "=" + (i * j));
//				if (j != i) {
//					System.out.println("\t");
//				}
//			}
//			System.out.println();
//		}
//	}
//}
public class MultiplicationTable {
    public static void main(String[] args) {
        // 九九乗法表
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "x" + i + "=" + (i * j));
                if (j != i) {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
}
