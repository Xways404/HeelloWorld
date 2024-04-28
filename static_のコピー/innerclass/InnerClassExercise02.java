package com.hspedu.static_.innerclass;

public class InnerClassExercise02 {
    public static void main(String[] args) {
        Cellphone cellphone = new Cellphone();
        cellphone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("雌豚はよ起きろー");
            }
        });
        cellphone.alarmClock(new Bell() {
           @Override
           public void ring() {
               System.out.println("授業始まるぞ");
           }
        });
    }
}
interface Bell {
    void ring();
}
class Cellphone {
    public void alarmClock(Bell bell) {//実引数がBellのインターフェース型である
        bell.ring();
    }
}
