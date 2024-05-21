package com.hspedu.jdbc.utils;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * @author Li Mi~
 * @version 1.0
 * JDBCUtilsツールクラスの使い方、dmlとselectを完成させる
 */
public class JDBCUtils_Use {
    @Test
    public void testSelect() {
        //1. 接続をゲット
        Connection connection = null;
        //2. sqlを組む
        String sql = "select * from actor";
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        //3. PreparedStatementオブジェクトを立ち上げる
        try {
            connection = JDBCUtils.getConnection();
//            System.out.println(connection.getClass()); //com.mysql.jdbc.JDBC4Connection
            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setInt(1, 5);//？に割り当てる
            //実行して、結果集をゲット
            set = preparedStatement.executeQuery();
            //結果集を走査する
            while (set.next()) {
                int id = set.getInt("id");
                String name = set.getString("name");
                String sex = set.getString("sex");
                Date borndate = set.getDate("borndate");
                String phone = set.getString("phone");
                System.out.println(id + "\t" + name + "\t" + sex + "\t" + borndate + "\t" + phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //資源閉鎖
            JDBCUtils.close(set, preparedStatement, connection);
        }
    }

    @Test
    public void testDML() {//insert , update, delete

        //1. 接続をゲット
        Connection connection = null;
        //2. sqlを組む
        String sql = "update actor set name = ? where id = ?";
        // deleteとinsertをテスト
        PreparedStatement preparedStatement = null;
        //3. PreparedStatementオブジェクトを立ち上げ
        try {
            connection = JDBCUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);
            //プレースホルダに割り当てを
            preparedStatement.setString(1, "周星驰");
            preparedStatement.setInt(2, 2);
            //実行
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // 錯誤情報をプリントアウト
        } finally {
            //資源閉鎖
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }
}
