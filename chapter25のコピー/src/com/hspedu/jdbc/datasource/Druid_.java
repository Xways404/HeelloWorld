package com.hspedu.jdbc.datasource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class Druid_ {
    @Test
    public void testDruid() throws Exception{
        //Druid jarパッケージを添付
        //設定ファイル導入
        //propertiesオブジェクトを作成
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/druid.properties"));

        //指定引数のデータベースコネクションプールを作成
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        long start = System.currentTimeMillis();
        for(int i = 0; i < 5000; i++) {
        Connection connection = dataSource.getConnection();
        connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }
}
