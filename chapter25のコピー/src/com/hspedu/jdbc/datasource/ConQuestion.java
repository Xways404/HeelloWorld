package com.hspedu.jdbc.datasource;

import com.hspedu.jdbc.utils.JDBCUtils;

import java.sql.Connection;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class ConQuestion {

    //コードでMySQLに5000回接続する
    public void testCon() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            //伝統的なjdbc方式で、接続をゲット
            Connection connection = JDBCUtils.getConnection();
            //
            JDBCUtils.close(null, null, connection);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
