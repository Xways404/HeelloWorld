package com.hspedu.jdbc.datasource;

import java.util.Date;

/**
 * @author Li Mi~
 * @version 1.0
 */
    public class Actor { //Javabean, POJO, Domainオブジェクト

        private Integer id;
        private String name;
        private String sex;
        private Date borndate;
        private String phone;

        public Actor() { //コンストラクター仮パラメータ型、リフレクションを行うため
        }

        public Actor(Integer id, String name, String sex, Date borndate, String phone) {
            this.id = id;
            this.name = name;
            this.sex = sex;
            this.borndate = borndate;
            this.phone = phone;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public Date getBorndate() {
            return borndate;
        }

        public void setBorndate(Date borndate) {
            this.borndate = borndate;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        @Override
        public String toString() {
            return "\nActor{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", sex='" + sex + '\'' +
                    ", borndate=" + borndate +
                    ", phone='" + phone + '\'' +
                    '}';
        }
}
