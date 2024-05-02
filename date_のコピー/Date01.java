package cao.hspedu.date_;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class Date01 {
    public static void main(String[] args) throws ParseException {

        //システム時間取得
        //日付のデフォルトは海外のフォームである、フォーム変換する必要がある
        Date d = new Date();
        System.out.println(d);

        Date d1 = new Date(9234567);
        System.out.println(d1);

        //日付のフォーム設定
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss E");
        String format = simpleDateFormat.format(d);
        System.out.println(format);

        //文字列Stringを　Dateに
        String s = "1994年01月21日 12:21:12 星期五";
        Date parse = simpleDateFormat.parse(s);
        System.out.println("parse: " + simpleDateFormat.format(parse));

    }
}
