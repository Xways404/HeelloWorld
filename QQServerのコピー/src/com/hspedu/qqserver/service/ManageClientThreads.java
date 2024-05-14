package com.hspedu.qqserver.service;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @author Li Mi~
 * @version 1.0
 *
 * このクラスはクライアントサイドとの通信してるスレッドを管理する
 */
public class ManageClientThreads {

    private static HashMap<String, ServerConnectClientThread> hm = new HashMap<>();

    //スレッドオブジェクトをhmコレクションに追加する
    public static void addClientThread(String userId, ServerConnectClientThread serverConnectClientThread) {

        hm.put(userId, serverConnectClientThread);

    }

    public static HashMap<String, ServerConnectClientThread> getHm() {
        return hm;
    }

    //userIdに基づいてスレッドを返す
    public static ServerConnectClientThread getServerConnectClientThread(String userId) {
        return hm.get(userId);
    }

    //コレクションからあるスレッドを削除するメソッドを作成
    public static void removeServerConnectClientThread(String userId) {
        hm.remove(userId);
    }

    //オンラインユーザーリストを返すメソッドを立ち上げ
    public  static String getOnlineUser() {
        //HashMapコレクションキーの値の走査を行う
        Iterator<String> iterator = hm.keySet().iterator();
        String onlineFriendList = "";
        while (iterator.hasNext()) {
            onlineFriendList += iterator.next().toString() + " ";
        }
        return onlineFriendList;
    }


}
