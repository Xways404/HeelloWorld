package com.hspedu.properties_;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class Properties03 {
    public static void main(String[] args) throws IOException {

        //Propertiesクラスで設定ファイルを立ち上げ、もしくは書き換えする
        //ファイルにkeyがなけりゃ、立ち上げされる、ありゃ書き換えされる

        Properties properties = new Properties();
        //立ち上げ
        properties.setProperty("charset", "utf8");
        properties.setProperty("user", "汤姆");
        properties.setProperty("pwd", "1sdfghjhtr");
        //k-v　ファイルに保存すればいい
        properties.store(new FileOutputStream("src/mysql2.properties"), null);
        System.out.println("設定ファイル保存完了y");




    }
}
