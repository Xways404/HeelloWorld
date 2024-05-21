package com.hspedu.dao_.test;

import com.hspedu.dao_.dao.ActorDAO;
import com.hspedu.dao_.domain.Actor;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class TestDAO {
    @Test
    //ActorDAOがactorテーブルに対する操作を　テスティング
    public void testActorDAO() {
        ActorDAO actorDAO = new ActorDAO();
        //セレクト
//        List<Actor> actors = actorDAO.queryMulti("select * from actor where id >= ?", Actor.class, 4);
//        System.out.println("===セレクト結果===");
//        for (Actor actor : actors) {
//            System.out.println(actor);
//        }
        Actor actor = actorDAO.querySingle("select * from actor where id >= ?", Actor.class, 4);
        System.out.println(actor);
    }



}
