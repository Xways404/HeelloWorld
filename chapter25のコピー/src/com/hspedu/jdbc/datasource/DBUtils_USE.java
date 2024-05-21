package com.hspedu.jdbc.datasource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class DBUtils_USE {
    @Test
    public void testQueryMany() throws SQLException {
        //接続ゲット
        Connection connection = JDBCUtilsByDruid.getConnection();
        //DBUtilsクラスとインターフェースを使って、DBUtils関連するjarを導入、
        //QueryRunnerを作成
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from actor where id >= ?";
        //queryメソッドがsql文を実行して、resultestをゲットしてArrayListにカプセル
        List<Actor> list =
                queryRunner.query(connection, sql, new BeanListHandler<>(Actor.class), 3);
        System.out.println("コレクションのデータを出力");
        for (Actor actor : list) {
            System.out.println(actor);
        }
        //資源解放
        JDBCUtilsByDruid.close(null, null, connection);
    }
    //apache-dbutils + druid 戻る結果は単行記録である
    @Test
    public void testQuerySingle() throws SQLException {

        //1. 接続ゲット (druid)
        Connection connection = JDBCUtilsByDruid.getConnection();
        //2. DBUtilsクラスとインターファースを使って、DBUtilsに関連するjarを導入
        //3. QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        //4. 関連メソッドを実行して、単一オブジェクトをゲット
        String sql = "select * from actor where id = ?";
        //
        Actor actor = queryRunner.query(connection, sql, new BeanHandler<>(Actor.class), 2);
        System.out.println(actor);

        // 資源解放
        JDBCUtilsByDruid.close(null, null, connection);

    }
}
