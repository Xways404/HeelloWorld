package com.hspedu.dao_.dao;


import com.hspedu.dao_.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Li Mi~
 * @version 1.0
 * BasicDAO その他DAOの親クラス
 */
public class BasicDAO<T> {//ジェネリクス　総称型具体的な類型を指定

    private QueryRunner qr = new QueryRunner();

    //任意なテーブルに通用されるdmlメソッドを開発
    public int update(String sql, Object... parameters) {

        Connection connection = null;

        try {
            connection = JDBCUtilsByDruid.getConnection();

            int update = qr.update(connection, sql, parameters);
            return update;
        } catch (SQLException e) {
            throw new RuntimeException(e);//コンパイル例外を実行例外としてスロー
        } finally {
            JDBCUtilsByDruid.close(null, null ,connection);
        }

    }
    //任意なテーブルに対して多数のオブジェクトを戻す(要は、多行セレクト結果)
    /**
     *
     * @param sql sql文、？割り当て記号
     * @param clazz クラスのCLassオブジェクトをパス、例：Actor.class
     * @param parameters　？の具体値をパス、
     * @return  Actor.classに基づき、応じたArrayListを戻す
     */
    public List<T> queryMulti(String sql, Class<T> clazz, Object... parameters) {
        Connection connection = null;

        try {
            connection = JDBCUtilsByDruid.getConnection();

            return qr.query(connection, sql, new BeanListHandler<T>(clazz), parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);//コンパイル例外を実行例外としてスロー
        } finally {
            JDBCUtilsByDruid.close(null, null ,connection);
        }
    }
    //単行
    public T querySingle(String sql, Class<T> clazz, Object... parameters) {
        Connection connection = null;

        try {
            connection = JDBCUtilsByDruid.getConnection();
            return qr.query(connection, sql, new BeanHandler<T>(clazz), parameters);

        } catch (Exception e) {
            throw new RuntimeException(e);//コンパイル例外を実行例外としてスロー
        } finally {
            JDBCUtilsByDruid.close(null, null ,connection);
        }
    }
    //単行単列
    public Object queryScalar(String sql, Object... parameters) {
        Connection connection = null;

        try {
            connection = JDBCUtilsByDruid.getConnection();
            return qr.query(connection, sql, new ScalarHandler(), parameters);

        } catch (SQLException e) {
            throw new RuntimeException(e);//コンパイル例外を実行例外としてスロー
        } finally {
            JDBCUtilsByDruid.close(null, null ,connection);
        }
    }
}
