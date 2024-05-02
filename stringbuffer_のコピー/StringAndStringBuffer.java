package cao.hspedu.stringbuffer_;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class StringAndStringBuffer {
    public static void main(String[] args) {

        // String -> StringBuffer
        String str = "Hello World";

        StringBuffer stringBuffer = new StringBuffer(str);

        StringBuffer stringBuffer1 = new StringBuffer();
        stringBuffer1 = stringBuffer1.append(str);

        // StringBuffer -> String
        StringBuffer stringBuffer3 = new StringBuffer("link start");
        String s = stringBuffer3.toString();
        String s1 = new String(stringBuffer3);


    }
}
