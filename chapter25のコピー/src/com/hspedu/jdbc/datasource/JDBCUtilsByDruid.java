package com.hspedu.jdbc.datasource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class JDBCUtilsByDruid {
    private static DataSource ds;

    //静的コードブロックでdsの初期化
    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //getConnectionメソッド
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    //接続閉鎖
    //Connectionオブジェクトをコネクションプールに戻す
    public static void close(ResultSet resultSet, Statement statement, Connection connection) {

        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
