package com.hspedu.jdbc.Statement_;

import com.sun.media.jfxmediaimpl.HostUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class Statement_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);
        //ユーザーにユーザー名とパスワードを入力してもらう
        System.out.print("ユーザー名を入力して");//next():スペースか’を受け取ったら終了の意味を示す
        String admin_name = scanner.nextLine();//SQLインジェクションは、nextLineで
        System.out.print("パスワードを入力して");
        String admin_pwd = scanner.nextLine();

        //propertiesオブジェクトに通じて設定ファイルの情報をゲット
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/mysql.properties"));
        //キーの値に通じてバリューの値をゲット
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        //ドライバー登録
        Class.forName(driver);
        //接続ゲット
        Connection connection = DriverManager.getConnection(url, user, password);
        //Statementゲット
        Statement statement = connection.createStatement();
        //Sql
        String sql = "select name, pwd from admin where name = '"+admin_name+"' and pwd = '"+admin_pwd+"'";
        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            System.out.println("登録完了");
        } else {
            System.out.println("登録失敗");
//            String name = resultSet.getString(1);
//            String pwd = resultSet.getString(2);
        }
        //接続閉鎖
        resultSet.close();
        statement.close();
        connection.close();
    }
}
