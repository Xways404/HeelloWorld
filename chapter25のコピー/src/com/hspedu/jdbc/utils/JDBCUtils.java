package com.hspedu.jdbc.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author Li Mi~
 * @version 1.0
 * ツールクラスとして、MySQLの接続と接続閉鎖を行わせる
 */
public class JDBCUtils {
    //関連変数４つを定義する、一つしか必要ないやから、静的にする
    private static String user; //ユーザー名
    private static String password; //パサワード
    private static String url; //url
    private static String driver; //ドライバー

    //静的コードブロックで初期化する
    static {

        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src/mysql.properties"));
            //関連変数を読み取る
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            driver = properties.getProperty("driver");
        } catch (IOException e) {
            //実際の開発では、このような処理ができる
            //1. コンパイル例外を実行例外に変換
            //2. コールする者が、例外をキャッチするか、もしくは例外をデフォルト処理で扱う
            throw new RuntimeException(e);
        }
    }

    //データベースを接続し、Connectionで戻す
    public static Connection getConnection() {

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            //1. コンパイル例外を実行例外に変換
            //2. コールする者が、例外をキャッチするか、もしくは例外をデフォルト処理で扱う
            throw new RuntimeException(e);
        }
    }

    //関連資源を閉鎖
    /*
        1. ResultSet 結果集
        2. Statement もしくは PreparedStatement
        3. Connection
        4. もし資源を閉鎖するならば、オブジェクトをパスする、でなけりゃnullをパス
     */
    public static void close(ResultSet set, Statement statement, Connection connection) {

        //nullであるか判断する
        try {
            if (set != null) {
                set.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            //コンパイル例外を実行例外に変換
            throw new RuntimeException(e);
        }

    }

}
