package com.hspedu.mhl.service;

import com.hspedu.mhl.dao.BillDAO;
import com.hspedu.mhl.dao.MultiTableDAO;
import com.hspedu.mhl.domain.Bill;
import com.hspedu.mhl.domain.MultiTableBean;

import java.util.List;
import java.util.UUID;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class BillService {
    //BellDAOを定義
    private BillDAO billDAO = new BillDAO();
    //MenuServiceを定義
    private MenuService menuService = new MenuService();
    //DiningTableServiceを定義
    private DiningTableService diningTableService = new DiningTableService();
    private MultiTableDAO multiTableDAO = new MultiTableDAO();


    //オーダーメソッドを作成
    //会計伝票を形成
    //対応な席の状況
    public boolean orderMenu(int menuId, int nums, int diningTableId) {
        //伝票番号形成、UUID
        String billID = UUID.randomUUID().toString();

        //伝票をbillテーブルに
        int update =
                billDAO.update
                        ("insert into bill values(null,?,?,?,?,?,now(),'未払い')",
                                billID, menuId, nums, menuService.getMenuById(menuId).getPrice() * nums, diningTableId);

        if (update <= 0) {
            return false;
        }
        //席状態を更新
        return diningTableService.updateDiningTableState(diningTableId, "在席中");
    }
    //伝票を戻す
    public List<Bill> list() {
        return billDAO.queryMulti("select * from bill", Bill.class);

    }
    public List<MultiTableBean> list2() {
        return multiTableDAO.queryMulti("SELECT bill.*, NAME " +
                "FROM bill, menu " +
                "WHERE bill.menuId = menu.id", MultiTableBean.class);
    }
    public boolean hasPayBillByDiningTableId(int diningTableId) {

        Bill bill =
                billDAO.querySingle
                        ("SELECT * FROM bill WHERE diningTableId=? AND state = '未払い' LIMIT 0, 1",
                                Bill.class, diningTableId);
        return bill != null;
    }
    public boolean payBill(int diningTableId, String payMode) {

        int update = billDAO.update("update bill set state=? where diningTableId=? and state='未结账'", payMode, diningTableId);

        if(update <= 0) {
            return false;
        }

        if(!diningTableService.updateDiningTableToFree(diningTableId, "空")) {
            return false;
        }
        return true;
    }
}
