package com.hspedu.static_.single_;

public class SingleTon01 {
    public static void main(String[] args) {
        //コンストラクターが私有化にしたため、GirlFriendをアクセスできぬ
//    GirlFriend g1 =new GirlFriend("g1");
//    GirlFriend g2 =new GirlFriend("g2");
        //メソッドを通じてオブジェクトを取得するのじゃな
        GirlFriend instance = GirlFriend.getInstance();
        System.out.println(instance);

        GirlFriend instance2 = GirlFriend.getInstance();
        System.out.println(instance2);

        System.out.println(instance == instance2) ;
    }


}
//「彼女」クラスを作成、かのじょ一つしかできない
class GirlFriend {
    private String name;

    //クラスの内部から直接立ち上げる

    private static GirlFriend g1 = new GirlFriend("Mary");

    //複数名の彼女を作ることができる
//    public GirlFriend(String name) {
//        this.name = name;
//    }
    //どうすりゃ、オブジェクト「彼女」を一つにするか
    //the answer is private
    private GirlFriend(String name) {
        this.name = name;
    }

    public static GirlFriend getInstance() {
        return g1;
    }

    @Override
    public String toString() {
        return "GirlFriend{" +
                "name='" + name + '\'' +
                '}';
    }
}
