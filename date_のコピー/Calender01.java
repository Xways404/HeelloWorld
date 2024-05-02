package cao.hspedu.date_;

import java.util.Calendar;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class Calender01 {
    public static void main(String[] args) {

        //Calenderは抽象クラス、コンストラクターはprivateである
        //インスタンスはげtInstance()で獲得
        //ファームが無いため、自分で組まなきゃ

        Calendar c = Calendar.getInstance();
        System.out.println(c);


    }
}
