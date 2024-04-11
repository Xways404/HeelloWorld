public class DoWhileExercise {
	public static void main(String[] args) {
		
		int i = 1;
		int sum = 0;
		int count = 0;
		do {
			if(i % 5 == 0 && i % 3 != 0) {
			System.out.println("i=" + i);
			count++;
			sum += i;
			}
			i++;
		}while(i <= 100);
		System.out.println(count);
		System.out.println(sum);
		
	}
}