package com.hspedu.jdbc.myjdbc;

/**
 * @author Li Mi~
 * @version 1.0
 * mysql データベースがjdbcインターファースを実現
 */
public class MysqlJdbcImpl implements JdbcInterface {
    @Override
    public Object getConnection() {
        System.out.println("mysqlの接続ができた");
        return null;
    }

    @Override
    public void crud() {
        System.out.println("mysqlのCRUDを完成");
    }

    @Override
    public void close() {
        System.out.println("mysqlの接続を閉鎖");
    }
}
