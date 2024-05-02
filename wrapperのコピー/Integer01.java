package cao.hspedu.wrapper;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class Integer01 {
    public static void main(String[] args) {
        //before JDK5
        //手動変換、int --> Integer
        int n1 = 100;
        Integer integer = new Integer(n1);
        Integer integer1 = Integer.valueOf(n1);

        //Integer --> int
        int i = integer.intValue();

        //after JDK5
        //everything be Auto
        int n2 = 200;
        Integer integer2 = n2;
        //実際には以下の動作を一回行った、本質は変わりがないが、自動変換になった
        //Integer integer3 = Integer.valueOf(n2);
        int n3 = integer2;//intValue();

        //クラスの特性を持っていればクラスメソッドを呼び出せる


    }
}
