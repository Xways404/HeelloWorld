package com.hspedu.jdbc.preparedstatement_;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author Li Mi~
 * @version 1.0
 *
 */
public class PreparedStatementDML {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        //ユーザーにユーザー名とパスワードを入力してもらう
        System.out.print("ユーザー名を入力して");//next():スペースか’を受け取ったら終了の意味を示す
        String admin_name = scanner.nextLine();//SQLインジェクションは、nextLineで
//        System.out.print("パスワードを入力して");
//        String admin_pwd = scanner.nextLine();

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

        //データを追加する
//        String sql  = "insert into admin values (?, ?)";
        //データを書き換え
//        String sql = "update admin set pwd = ? where name = ?";
        //データを削除
        String sql = "delete from admin where name = ?";


        //preparedStatementはPreparedStatementインターフェースの実現クラスのオブジェクトである
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //？に割り当てする
        preparedStatement.setString(1, admin_name);
//        preparedStatement.setString(2, admin_pwd);

        //dml文を実行するにはexecuteUpdateを使う
        int rows = preparedStatement.executeUpdate();
        System.out.println(rows > 0 ? "実行完了" : "実行不能");

        //接続閉鎖
        preparedStatement.close();
        connection.close();

    }

}
