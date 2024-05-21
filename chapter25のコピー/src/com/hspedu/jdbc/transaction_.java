package com.hspedu.jdbc;

import com.hspedu.jdbc.utils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Li Mi~
 * @version 1.0
 * トランザクションの使い方
 */
public class transaction_ {
    //トランザクションを使用しない場合
    @Test
    public void noTransaction() {

        //振り込み業務を操作する
        //1. 接続をゲット
        Connection connection = null;
        //2. sqlを組む
        String sql = "update account set balance = balance - 100 where id = 1";
        String sql2 = "update account set balance = balance + 100 where id = 2";
        PreparedStatement preparedStatement = null;
        //3. PreparedStatementオブジェクトを立ち上げ
        try {
            connection = JDBCUtils.getConnection(); // デフォルトの状況において、connectionは自動コミットされる
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate(); // 第一文目sqlを実行

            int i = 1 / 0; //例外スロー

            // そうなると、第二文目sqlが実行されなくなり、MySQLでは第一文目だけ反映される

            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate(); // 第二文目sqlを実行

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //資源閉鎖
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }

    //トランザクションで解決
    @Test
    public void useTransaction() {

        //振り込み業務を操作する
        //1. 接続をゲット
        Connection connection = null;
        //2. sqlを組む
        String sql = "update account set balance = balance - 100 where id = 1";
        String sql2 = "update account set balance = balance + 100 where id = 2";
        PreparedStatement preparedStatement = null;
        //3. PreparedStatementオブジェクトを立ち上げ
        try {
            connection = JDBCUtils.getConnection(); //デフォルトの状況において、connectionは自動コミットされる
            //connection自動コミットでないに設定する
            connection.setAutoCommit(false); //トランザクションを開始とする
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate(); //第一文目sqlを実行

//            int i = 1 / 0; //例外をスロー
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate(); // 第二分目sqlを実行

            //トランザクションをコミット
            connection.commit();

        } catch (SQLException e) {
            //ここでロールバックすることができ、実行されたsql文を取り消せる
            //トランザクションが始まる状態にロールバックする
            System.out.println("実行例外発生、sql実行を取り消す");
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            //資源閉鎖
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }
}
