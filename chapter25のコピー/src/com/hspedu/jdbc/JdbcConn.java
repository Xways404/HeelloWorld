package com.hspedu.jdbc;

import com.mysql.jdbc.Driver;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class JdbcConn {
    //接続方式１
    @Test
    public void connect01() throws SQLException {
        Driver driver = new Driver();//ドライバーオブジェクトを作成
        String url = "jdbc:mysql://localhost:3306/hsp_db02";
        //ユーザ名とパスワードをPropertiesオブジェクトに入れる
        Properties properties = new Properties();
        //user,passwordのキー値が決まっている、変えてはならぬ
        properties.setProperty("user", "root");//ユーザー
        properties.setProperty("password", "lzx521599");//パスワード
        Connection connect = driver.connect(url, properties);
        System.out.println("接続方式1：　"  + connect);
    }
    //接続方式２
    @Test
    public void connect02() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        //リレクションでドライバークラスをロードする、リレクションは動的ロードである、依頼性を削減できる
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver)aClass.newInstance();
        String url = "jdbc:mysql://localhost:3306/hsp_db02";
        //ユーザ名とパスワードをPropertiesオブジェクトに入れる
        Properties properties = new Properties();
        //user,passwordのキー値が決まっている、変えてはならぬ
        properties.setProperty("user", "root");//ユーザー
        properties.setProperty("password", "lzx521599");//パスワード
        Connection connect = driver.connect(url, properties);
        System.out.println("接続方式2：　"  + connect);
    }

    //接続方式３
    @Test
    public void connect03() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        //DiverManagerを使ってDriverを入れ替え、同一管理を行う
        //リフレクションでDriverをロードする
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver)aClass.newInstance();
        //url user password
        String url = "jdbc:mysql://localhost:3306/hsp_db02";
        String user = "root";
        String password = "lzx521599";

        DriverManager.registerDriver(driver);//ドライバー登録
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("接続方式3：　"  + connection);
    }
    //接続方式４
    //最も使われる
    @Test
    public void connect04() throws ClassNotFoundException, SQLException {
        //Class.foNameでドライバー登録を自動完成させる、コードを簡潔にする
        //リフレクションでDriverクラスをロードする
        //Driverクラスをロードするこきに登録完了
        Class.forName("com.mysql.jdbc.Driver");
        //url user password
        String url = "jdbc:mysql://localhost:3306/hsp_db02";
        String user = "root";
        String password = "lzx521599";
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("接続方式4：　"  + connection);
    }
    //接続方式5
    @Test
    public void connect05() throws ClassNotFoundException, IOException, SQLException {
        //設定ファイルを書いて、データベースの接続をもっとスムーズに
        //propertiesオブジェクトに通じて設定ファイルの情報をゲット
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/mysql.properties"));
        //キーの値に通じてバリューの値をゲット
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("接続方式5：　"  + connection);
    }
}
