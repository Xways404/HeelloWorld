public class IfExercise01 {
	public static void main(String[] args) {
		
		double num1 = 11.5;
		double num2 = 4.7;
		if (num1 > 10.0 && num2 < 20.0) {
			System.out.println(num1 + num2);
		} 
		
		int i1 = 150;
		int i2 = 30;
		int sum1 = i1 + i2;
		if(sum1 % 3 == 0 && sum1 % 5 == 0) {
			System.out.println("ok");
		} else {
			System.out.println("no way");
		}
		 
		int year = 2024;
		if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
			System.out.println("閏年");
		} else {
			System.out.println("平年");
		}
	}
}