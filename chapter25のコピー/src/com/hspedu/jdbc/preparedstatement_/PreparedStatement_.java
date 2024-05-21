package com.hspedu.jdbc.preparedstatement_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class PreparedStatement_ {
    public static void main(String[] args) throws Exception {

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
        //PreparedStatementゲット
        //Sql文の？代用語とする
        String sql = "select name, pwd from admin where name = ? and pwd = ?";

        //preparedStatementはPreparedStatementインターフェースの実現クラスのオブジェクトである
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //？に割り当てする
        preparedStatement.setString(1, admin_name);
        preparedStatement.setString(2, admin_pwd);
        //select文を実行するにはexecuteQueryを使う
        //
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            System.out.println("登録完了");
        } else {
            System.out.println("登録失敗");
//            String name = resultSet.getString(1);
//            String pwd = resultSet.getString(2);
        }
        //接続閉鎖
        resultSet.close();
        preparedStatement.close();
        connection.close();

    }
}
