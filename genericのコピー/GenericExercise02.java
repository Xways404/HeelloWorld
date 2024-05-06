package com.hspedu.generic;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class GenericExercise02 {
    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("tom", 20000, new MyDate(2000, 11, 11)));
        employees.add(new Employee("tom", 12000, new MyDate(2001, 12, 12)));
        employees.add(new Employee("tom", 50000, new MyDate(2000, 10, 10)));

        System.out.println("employees = " + employees);


        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee emp1, Employee emp2) {
                //まずnameソートする、nameが同じであれば、誕生日の前後でソート
                //導入されたパラメータを認証する
                if(!(emp1 instanceof Employee && emp2 instanceof Employee)){
                    System.out.println("型不正。。。。");
                    return 0;
                }
                //name 比較
                int i = emp1.getName().compareTo(emp2.getName());
                if(i != 0){
                    return i;
                }

                //以下は誕生日の比較で、だからMyDateクラスで比較をカプセルしたほうがいい
                //name 同様であれば、誕生日(年)前後を比較
//                int yearMinus = emp1.getBirthday().getYear() - emp2.getBirthday().getYear();
//                if(yearMinus != 0){
//                    return yearMinus;
//                }
//                //誕生日(年)が等しいであれば、誕生日(月)を比較
//                int monthMinus = emp1.getBirthday().getMonth() - emp2.getBirthday().getMonth();
//                if(monthMinus != 0){
//                    return monthMinus;
//                }
//                //誕生日(月)が等しいければ、誕生日(日)を比較
//                return emp1.getBirthday().getDay() - emp2.getBirthday().getDay();
                return emp1.getBirthday().compareTo(emp2.getBirthday());

            }
        });

        System.out.println("-------After-------");
        System.out.println(employees);


    }
}
