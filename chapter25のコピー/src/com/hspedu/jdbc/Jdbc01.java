package com.hspedu.jdbc;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author Li Mi~
 * @version 1.0
 * jdbcプログラムである、簡単な操作を実現
 */
public class Jdbc01 {
    public static void main(String[] args) throws SQLException {
        //前提準備：プロジェクトでディレクトリを作成する、libs
        //MySQLをこのlibsにコピーする　add as libraryライブラリに追加する

        //ドライバーをロード
        Driver driver = new Driver();

        //接続をゲット
        //urlはどのデータベースに接続するかを示す
        //jdbc:mysql://規定されてる
        //MySQLの接続の基底としては、ソケット接続である
        String url = "jdbc:mysql://localhost:3306/hsp_db02";
        //ユーザ名とパスワードをPropertiesオブジェクトに入れる
        Properties properties = new Properties();
        //user,passwordのキー値が決まっている、変えてはならぬ
        properties.setProperty("user", "root");//ユーザー
        properties.setProperty("password", "lzx521599");//パスワード
        Connection connect = driver.connect(url, properties);


        //sqlを実行
//        String sql = "insert into actor values(null, '田中', '男', '1978-11-11', '110')";
//        String sql = "update actor set name = '藤原' where id = 1";
        String sql = "delete from actor where id = 1";
        //sqlの指令を実行することができる、結果オブジェクトを戻す
        Statement statement = connect.createStatement();
        int rows = statement.executeUpdate(sql);//rows,戻されるのか影響された行数である、１、０
        System.out.println(rows > 0 ? "成功" : "失敗");

        //接続を閉鎖
        statement.close();
        connect.close();

    }
}
