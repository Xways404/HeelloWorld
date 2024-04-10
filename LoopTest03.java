public class LoopTest03 {
	public static void main(String[] args) {
		
		int count = 0;
		
		for(int num = 1; num <= 100; num++) {
			if(num % 5 != 0) {
				count++;
				System.out.print(num + "\t");
				if(count % 5 == 0) {
					System.out.println();
				}
			}
		}
		
	}
}
