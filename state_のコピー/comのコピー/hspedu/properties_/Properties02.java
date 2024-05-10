package com.hspedu.properties_;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class Properties02 {
    public static void main(String[] args) throws IOException {
        //Propertiesクラスでmysql.propertiesファイルを読み取る

        //Propertiesオブジェクトを作成
        Properties properties = new Properties();
        //指定された設定ファイルをローディングする
        properties.load(new FileReader("src/mysql.properties"));
        //もうロードされたから、kーvを表示して入手する
        properties.list(System.out);
        //入手したいデータ、要はインフォを指定してする場合
        //キーに基づいて、応じた値を入手
        //userを指定して、user=....の後の値を戻してもらう
        //戻される値は文字列Stringである
        String user = properties.getProperty("user");
        //出力
        System.out.println("ユーザー名　：　" + user);


        //クローズしなかん

    }
}
