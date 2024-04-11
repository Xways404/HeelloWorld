public class ForDetail {
	public static void main(String[] args) {
		
		int count = 3;
		
		for(int i = 0, j = 0; i < count; i++, j += 2) {
			System.out.println("i=" + i + "j=" + j);
		}
		
		 System.out.println("down");
	}
}