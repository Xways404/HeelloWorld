package cao.hspedu.wrapper;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class WrapperVSString {
    public static void main(String[] args) {


    //ラッパークラス(Integer) -> String
    Integer i = 100;
    //方式１
    //iの値を文字列に変換しただけど、iの本来のデータ型に関してはなんの変わりもない
    String str1 = i + "";//"i" = "100"
    //方式２
    String str2 = i.toString();
    //方式３
    String str3 = String.valueOf(i);

    //String -> ラッパークラス(Integer)
    String str4 = "12345";
    //方式１
    Integer i2 = Integer.parseInt(str4);//Auto
    //方式2
    Integer i3 = new Integer(str4);//コンストラクター


    }
}
