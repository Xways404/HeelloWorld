package cao.hspedu.string_;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class String01 {
    public static void main(String[] args) {

        //String オブジェクトは文字列の保存として用いられる
        //"jack"は文字列の定数である
        //Stringクラスがたくさんのコンストラクターを持ってて、コンストラクターのオーバーロード
        //Stringはfinalクラス、継承することができない
        //String　private final char value[]; 文字列内容の保存
        //valueはfinalの型であり、修正してはならぬ
        String name = "jack";
        name = "tom";
        final char[] value = {'a', 'b', 'c'};
        char[] v2 = {'d', 'e', 'f'};
        value[0] = 'H';
        //value = v2; final変数valueに値を代入することはできません


    }
}
