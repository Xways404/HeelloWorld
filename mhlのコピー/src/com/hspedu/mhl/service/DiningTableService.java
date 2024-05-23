package com.hspedu.mhl.service;

import com.hspedu.mhl.dao.DiningTableDAO;
import com.hspedu.mhl.domain.DiningTable;

import java.util.List;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class DiningTableService {//業務層
    //DiningTableDAOオブジェクト
    private DiningTableDAO diningTableDAO = new DiningTableDAO();

    //席情報を戻す
    public List<DiningTable> list() {

        return diningTableDAO.queryMulti
                ("select id, state from diningTable", DiningTable.class);

    }

    //idに基づき、応じたDiningTableオブジェクトをセレクト
    //戻す値がnullであれば、idが対応する席が空席である
    public DiningTable getDiningTableById(int id) {
        //sql文を事前にテスティングしたほうがいい
        return diningTableDAO.querySingle
                ("select * from diningTable where id = ?", DiningTable.class, id);
    }

    //もし席の予約を取れるなら、メソッドをコールして、席状況を更新する(予約名と電話)
    public boolean orderDiningTable(int id, String orderName, String orderTel) {

        int update = diningTableDAO.update
                ("update diningTable set state='予約済み', orderName=?, orderTel=? where id=?",
                        orderName, orderTel, id);

        return update > 0;
    }
    //席状況を更新するメソッドが必要
    public boolean updateDiningTableState(int id, String state) {

        int update = diningTableDAO.update("update diningTable set state=? where id=?", state, id);
        return update > 0;
    }

    public boolean updateDiningTableToFree(int id, String state) {

        int update = diningTableDAO.update("update diningTable set state=?,orderName='',orderTel='' where id=?", state, id);
        return update > 0;
    }

}
