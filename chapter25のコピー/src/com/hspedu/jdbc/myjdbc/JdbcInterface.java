package com.hspedu.jdbc.myjdbc;

/**
 * @author Li Mi~
 * @version 1.0
 * 規定されたjdbcインターファース　メソッド
 */
public interface JdbcInterface {

    //接続
    public Object getConnection();
    //crud
    public void crud();
    //接続閉鎖
    public void close();

}
