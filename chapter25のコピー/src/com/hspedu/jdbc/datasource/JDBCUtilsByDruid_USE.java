package com.hspedu.jdbc.datasource;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class JDBCUtilsByDruid_USE {
    @Test
    public void testSelect() {

        System.out.println("使用 druid方式完成");
        //1. 得到连接
        Connection connection = null;
        //2. 组织一个sql
        String sql = "select * from actor where id >= ?";
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        //3. 创建PreparedStatement 对象
        try {
            connection = JDBCUtilsByDruid.getConnection();
            System.out.println(connection.getClass());//运行类型 com.alibaba.druid.pool.DruidPooledConnection
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 1);//给?号赋值
            //执行, 得到结果集
            set = preparedStatement.executeQuery();

            //遍历该结果集
            while (set.next()) {
                int id = set.getInt("id");
                String name = set.getString("name");//getName()
                String sex = set.getString("sex");//getSex()
                Date borndate = set.getDate("borndate");
                String phone = set.getString("phone");
                System.out.println(id + "\t" + name + "\t" + sex + "\t" + borndate + "\t" + phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtilsByDruid.close(set, preparedStatement, connection);
        }
    }

    //ResultSet =カプセル=> Arraylist  ArrayList<Actor>
    @Test
    public void testSelectToArrayList() {

        System.out.println("使用 druid方式完成");
        //1. 接続をゲット
        Connection connection = null;
        //2. sqlを組む
        String sql = "select * from actor where id >= ?";
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        ArrayList<Actor> list = new ArrayList<>();//ArrayListオブジェクトにactorオブジェクトを入れる
        //3. PreparedStatement オブジェクト
        try {
            connection = JDBCUtilsByDruid.getConnection();
            System.out.println(connection.getClass());//コンパイル型 com.alibaba.druid.pool.DruidPooledConnection
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 1);//？に割り当て
            //実行、結果集をゲット
            set = preparedStatement.executeQuery();

            //结果集を走査する
            while (set.next()) {
                int id = set.getInt("id");
                String name = set.getString("name");//getName()
                String sex = set.getString("sex");//getSex()
                Date borndate = set.getDate("borndate");
                String phone = set.getString("phone");
                //ゲットできたresultsetの記録をActorオブジェクトにカプセル、listコレクションに入れる
                list.add(new Actor(id, name, sex, borndate, phone));
            }

            System.out.println("listコレクションデータ=" + list);
            for(Actor actor : list) {
                System.out.println("id=" + actor.getId() + "\t" + actor.getName());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //資源閉鎖
            JDBCUtilsByDruid.close(set, preparedStatement, connection);
        }
        //ArrayList と connection 連携がないため、コレクションが重複使える
//        return list;
    }
}
