package com.hspedu.houserent.domain;
/**
* Houseオブジェクトは部屋のデータを表示
*/
public class House {
//    番号　オーナー　電話　住所　家賃　契約状況
    private int id;
    private String name;
    private String phone;
    private String address;
    private int rent;
    private String state;

    public House(int id, String name, String phone, String address, int rent, String state) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.rent = rent;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    //これから容易にオブジェクトをデータを出力するために、toStringを先に書いておく

    @Override
    public String toString() {
        return  id +
                "\t\t" + name +
                "\t\t\t" + phone +
                "\t\t" + address +
                "\t\t" + rent +
                "\t" + state ;
    }
}
