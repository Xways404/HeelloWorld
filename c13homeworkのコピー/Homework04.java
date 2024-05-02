package cao.hspedu.c13homework;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class Homework04 {
    public static void main(String[] args) {
        String str = "asd453243refAFDFDE";
        countStr(str);
    }
    public static void countStr(String str) {
        if(str == null) {
            System.out.println("not can be null");
            return;
        }
        int numCount = 0;
        int lowerCount = 0;
        int upperCount = 0;
        int otherCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                numCount++;
            } else if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                lowerCount++;
            } else if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                upperCount++;
            } else {
                otherCount++;
            }
        }
        System.out.println("numCount" + numCount);
        System.out.println("lowerCount" + lowerCount);
        System.out.println("upperCount" + upperCount);
        System.out.println("otherCount" + otherCount);
    }
}
