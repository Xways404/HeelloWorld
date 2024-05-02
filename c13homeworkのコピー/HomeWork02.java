package cao.hspedu.c13homework;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class HomeWork02 {
    public static void main(String[] args) {

        String name = "jack";
        String pwd = "123456";
        String email = "jack@gmail.com";

        try {
            userRegister(name, pwd, email);
            System.out.println("congratulations! you got your new ID");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //ユーザー名長さ２、３、４文字
    //パスワード長さ　６位
    //eメール＠と.を含む必要があり、＠は.の前になるように
    public static void userRegister(String name, String pwd, String email) {



        //name認証
        int userLength = name.length();
        if(!(userLength >= 2 && userLength <= 4)) {
            throw new RuntimeException("ユーザー名長さ２、３、４文字");
        }
        //パスワード認証
        if(!(pwd.length() == 6 && isDigital(pwd))) {
            throw new RuntimeException("パスワード長さ６位number");
        }

        //eメール＠と.を含む必要があり、＠は.の前になるように
        int i = email.indexOf('@');
        int j = email.indexOf(".");
        if(!(i > 0 && j > i)) {
            System.out.println("eメール＠と.を含む必要があり、＠は.の前になるように");
        }
    }
    public static boolean isDigital(String str) {
        char[] chars = str.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] < '0' || chars[i] > '9') {
                return false;
            }
        }
        return true;
    }
}
