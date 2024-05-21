package com.hspedu.jdbc.datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class C3P0_ {
    @Test
    public void testC3P0_01() throws Exception {

        //データソースオブジェクトを作成
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        //設定ファイルmysql.propertiesで関連する情報をゲット
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/mysql.properties"));
        //関連変数を読み取る
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        //データソースに　comboPooledDataSource 関連引数を設置
        //接続管理：comboPooledDataSource
        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);

        //接続数の初期化を設定
        comboPooledDataSource.setInitialPoolSize(10);
        //最大接続数
        comboPooledDataSource.setMaxPoolSize(50);
        //コネクションプールの効率を試す
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            Connection connection = comboPooledDataSource.getConnection();//このメソッドはDataSourceインターフェースから実現された
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    //方式２　設定ファイルで完成させる
    //c3p0が提供したc3p0-condig.xmlファイルをsrcにコピーする
    //このファイルはデータベースコネクションとコネクションプールの関連引数を指定した
    @Test
    public void testC3P0_02() throws Exception {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("hsp_edu");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            Connection connection = comboPooledDataSource.getConnection();
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
