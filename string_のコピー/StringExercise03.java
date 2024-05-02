package cao.hspedu.string_;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class StringExercise03 {
    public static void main(String[] args) {

        String a = "hsp"; //a　コンスタントプールの"hsp"を指してる
        String b = new String("hsp");//b　ヒープのオブジェクトを指してる

        System.out.println(a.equals(b));
        System.out.println(a == b);
        System.out.println(a == b.intern());//b.intern()は"hsp"のコンスタントプールを指してる
        System.out.println(b == b.intern());
    }
}
