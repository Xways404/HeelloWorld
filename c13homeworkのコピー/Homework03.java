package cao.hspedu.c13homework;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class Homework03 {
    public static void main(String[] args) {
        String name = "Casd Hjas Ijas";
        printName(name);

    }

    //Han Shun Ping
    //文字を分割する、スペースごとに、
    //得た文字列を、形式編集してString.format()
    //入力されたデータを認証する
    public static void printName(String str) {
        if (str == null) {
            System.out.println("can not be null");
            return;
        }
        String[] names = str.split(" ");
        if (!(names.length == 3)) {
            System.out.println("your String format not be ok");
            return;
        }
        String format = String.format("%s,%s.%c", names[2], names[0], names[1].toUpperCase().charAt(0));
        System.out.println(format);


    }
}
