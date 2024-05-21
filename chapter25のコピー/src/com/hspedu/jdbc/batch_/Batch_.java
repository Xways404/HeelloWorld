package com.hspedu.jdbc.batch_;

import com.hspedu.jdbc.utils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author Li Mi~
 * @version 1.0
 * バッチ処理
 */
public class Batch_ {

    //伝統方式で5000件の情報をadmin２に追加する
    @Test
    public void noBatch() throws Exception {

        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into admin2 values(null, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("実行開始");
        long start = System.currentTimeMillis();// 開始時間
        for (int i = 0; i < 5000; i++) {// 5000件実行
            preparedStatement.setString(1, "jack" + i);
            preparedStatement.setString(2, "666");
            preparedStatement.executeUpdate();
        }
        long end = System.currentTimeMillis();
        System.out.println("伝統方式でかかった時間=" + (end - start));
        //接続閉鎖
        JDBCUtils.close(null, preparedStatement, connection);
    }

    //バッチ処理でデータ追加
    @Test
    public void batch() throws Exception {

        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into admin2 values(null, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("実行開始");
        long start = System.currentTimeMillis();//開始時間
        for (int i = 0; i < 5000; i++) {//5000件実行
            preparedStatement.setString(1, "jack" + i);
            preparedStatement.setString(2, "666");
            //sql文をバッチパッケージに入れて -> ソースコードをみる
            /*
            //1. //まず ArrayList - elementData => Object[]
            //2. elementData => Object[] 処理準備するsql文を保存
            //3. elementDataが満タンになったら,1.5倍拡張する
            //4. 指定された値まで追加した後，executeBatch
            //5. バッチ処理はsqlを送信するネットワーク利用率を削減することができる、コンパイル回数を減らせる
            public void addBatch() throws SQLException {
                synchronized(this.checkClosed().getConnectionMutex()) {
                    if (this.batchedArgs == null) {

                        this.batchedArgs = new ArrayList();
                    }
                     for(int i = 0; i < this.parameterValues.length; ++i) {
                        this.checkAllParametersSet(this.parameterValues[i], this.parameterStreams[i], i);
                    }

                    this.batchedArgs.add(new PreparedStatement.BatchParams(this.parameterValues, this.parameterStreams, this.isStream, this.streamLengths, this.isNull));
                }
            }

             */
            preparedStatement.addBatch();
            //1000件の記録がある際に、バッチ処理
            if((i + 1) % 1000 == 0) {//1000件になったらsql実行
                preparedStatement.executeBatch();
                //からにする
                preparedStatement.clearBatch();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("バッチ処理で消耗した時間=" + (end - start));//批量方式 耗时=108
        //接続閉鎖
        JDBCUtils.close(null, preparedStatement, connection);
    }

}
