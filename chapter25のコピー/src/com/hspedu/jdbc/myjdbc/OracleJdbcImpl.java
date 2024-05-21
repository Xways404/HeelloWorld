package com.hspedu.jdbc.myjdbc;

/**
 * @author Li Mi~
 * @version 1.0
 * oracle データベースでjdbcを実現
 */
public class OracleJdbcImpl implements JdbcInterface{
    @Override
    public Object getConnection() {
        System.out.println("ORACLEとの接続できた");
        return null;
    }

    @Override
    public void crud() {
        System.out.println("OracleのCRUDを完成");
    }

    @Override
    public void close() {
        System.out.println("oracleの接続を閉鎖");
    }
}
