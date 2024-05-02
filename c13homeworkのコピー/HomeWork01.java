package cao.hspedu.c13homework;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class HomeWork01 {
    public static void main(String[] args) {

        String str = "abcdef";
        System.out.println(str);

        try {
            String reverse = reverse(str, 13, 4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println(str);





    }
    // abcdefをaedcbfに順番入れ替えて実現
    // String を　char[]に変換する、char[]の変数は入れ替え可能であるため
    public static String reverse(String str, int start, int end) {
        //入力された仮引数に対して認証する
        //まず正しい運行状況を書き出す
        if(!(str != null && start >= 0 && end < str.length() && start < end)) {
            throw new RuntimeException("不正仮引数");
        }
        char[] chars = str.toCharArray();
        char temp = ' ';
        for (int i = start, j = end; i < j; i++, j--) {
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return new String(chars);
    }
}
