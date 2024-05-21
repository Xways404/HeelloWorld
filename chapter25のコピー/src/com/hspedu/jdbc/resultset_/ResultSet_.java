package com.hspedu.jdbc.resultset_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class ResultSet_ {
    public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
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
        String sql = "select id, name, sex, borndate from actor";
        //sql文を実行して、ResultSetオブジェクトを戻す
        ResultSet resultSet = statement.executeQuery(sql);
        //while繰り返し処理で　データを取り出し
        while (resultSet.next())  {
            int id = resultSet.getInt(1);//行の列一番目のデータをゲット
            String name = resultSet.getString(2);
            String sex = resultSet.getString(3);
            Date date = resultSet.getDate(4);
            System.out.println(id + "\t" + name + "\t" + sex + "\t" + date);


        }

        //接続閉鎖
        resultSet.close();
        statement.close();
        connection.close();
    }
}
