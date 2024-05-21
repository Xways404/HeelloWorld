package com.hspedu.jdbc.myjdbc;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class TestJDBC {
    public static void main(String[] args) {
        //mysqlに対する操作を完成する
        JdbcInterface jdbcInterface = new MysqlJdbcImpl();
        //インターフェースに通じて実現クラスをコールする、動的束縛
        jdbcInterface.getConnection();
        jdbcInterface.crud();
        jdbcInterface.close();

        //Oracleに対する操作を完成する
        System.out.println("====================");
        JdbcInterface jdbcInterface1 = new OracleJdbcImpl();
        //インターフェースに通じて実現クラスをコールする、動的束縛
        jdbcInterface1.getConnection();
        jdbcInterface1.crud();
        jdbcInterface1.close();

    }
}
