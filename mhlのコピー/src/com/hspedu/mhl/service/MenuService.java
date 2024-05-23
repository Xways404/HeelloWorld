package com.hspedu.mhl.service;

import com.hspedu.mhl.dao.MenuDAO;
import com.hspedu.mhl.domain.Menu;

import java.util.List;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class MenuService {

    //MenuDAOを定義
    private MenuDAO menuDAO = new MenuDAO();

    //メニューを全部Viewに返して使用させる、
    public List<Menu> list() {
        return menuDAO.queryMulti("select * from menu", Menu.class);
    }
    //idに基づき、Menuオブジェクトを戻す
    public Menu getMenuById(int id) {
        return menuDAO.querySingle("select * from menu where id = ?", Menu.class, id);
    }
}
