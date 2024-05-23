package com.hspedu.mhl.service;

import com.hspedu.mhl.dao.EmployeeDAO;
import com.hspedu.mhl.domain.Employee;

/**
 * @author Li Mi~
 * @version 1.0
 * employeeテーブルに対する操作を行う(EmployeeDAOオブジェクトのコールに通じてる)
 */
public class EmployeeService {

    //EmployeeDAOオブジェクトを定義する
    private EmployeeDAO employeeDAO = new EmployeeDAO();

    //empIdとpwdに基づいてEmployeeオブジェクトを戻す
    //見つからない場合、nullを戻す
    public Employee getEmployeeByIdAndPwd(String empId, String pwd) {

        return employeeDAO.querySingle
                ("select * from employee where empId=? and pwd=md5(?)", Employee.class, empId, pwd);

    }

}
