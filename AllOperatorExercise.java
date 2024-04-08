public class AllOperatorExercise {
	public static void main(String[] args) {
		
		System.out.println(10 / 3);//3
		System.out.println(10 / 5);//2
		System.out.println(10 % 2);//0
		//a%b aが小数である時には、公式は、a-(int)a/b*b;
		//-10.5%3= -10.5-(-10)/3*3=-1.5
		System.out.println(-10.5 % 3);//-1.5
		System.out.println(-10.4 % 3);
		
		int i = 66;
		// ++i = 67,i = 67,i + i = 134
		System.out.println(++i + i);
		
		/*
		int num1 =(int)"18";
		int num2 = 18.0;
		double num3 = 3d;
		double num4 = 8;
		
		int n =48;
		char ch = i +1;
		
		byte b = 19;
		short s =b + 2;
		*/
	}
}