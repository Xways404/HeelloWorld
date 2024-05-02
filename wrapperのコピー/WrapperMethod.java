package cao.hspedu.wrapper;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class WrapperMethod {
    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);//最小値で返す
        System.out.println(Integer.MAX_VALUE);//最大値で返す

        System.out.println(Character.isDigit('a'));//数字であるか判断
        System.out.println(Character.isLetter('a'));//アルファベットであるか判断
        System.out.println(Character.isUpperCase('a'));//大文字なのか判断
        System.out.println(Character.isLowerCase('a'));//小文字なのか判断

        System.out.println(Character.isWhitespace('a'));//スペースであるか判断
        System.out.println(Character.toUpperCase('a'));//大文字に変更
        System.out.println(Character.toLowerCase('A'));//小文字に変更
    }
}
