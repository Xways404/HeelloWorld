package com.hspedu.properties_;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class Properties01 {
    public static void main(String[] args) throws IOException {

        //mysql.propertiesファイルを読み取り、ip, user, pwdを入手する
        BufferedReader br = new BufferedReader(new FileReader("src/mysql.properties"));
        String line = "";
        while((line = br.readLine()) != null) { //繰り返し読み取り処理
            String[] split = line.split("=");
            System.out.println(split[0] + "　Value is " + split[1]);

        }
        br.close(); //ストリームを停止する


    }
}
