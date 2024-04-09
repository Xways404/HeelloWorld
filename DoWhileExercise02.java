import java.util.Scanner;
public class DoWhileExercise02 {
	public static void main(String[] args) {
		char answer = 'y';
		Scanner myScanner = new Scanner(System.in); 
		do {
			System.out.println("ぶっ殺すぞ貴様！");
			System.out.println("借りたお金はよ返せー");
			answer = myScanner.next().charAt(0);
			System.out.println("彼の返答は、" + answer);
		}while(answer != 'y');
		System.out.println("ようやく返してくれたな、もう二度と貸さん");
	}
}