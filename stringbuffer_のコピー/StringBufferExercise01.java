package cao.hspedu.stringbuffer_;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class StringBufferExercise01 {
    public static void main(String[] args) {
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        System.out.println(sb.length());

        System.out.println(sb);
        StringBuffer sb1 =new StringBuffer(str);
        System.out.println(sb1);


    }
}
