package cao.hspedu.stringbuffer_;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class StringBufferExercise02 {
    public static void main(String[] args) {


        String price = "1245673456.78";
        StringBuffer sb = new StringBuffer(price);
        // 123,456.78
        //　小数点のインデックスを見つけ、そのインデックスの３個前にコンマを入れ込む
//        int i = sb.lastIndexOf(".");
//        sb.insert(i - 3, ",");


        for(int i = sb.lastIndexOf(".") - 3; i > 0; i -= 3) {
            sb.insert(i, ",");
        }
        System.out.println(sb);



    }
}
