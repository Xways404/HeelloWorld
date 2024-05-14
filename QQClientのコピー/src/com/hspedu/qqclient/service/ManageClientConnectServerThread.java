package com.hspedu.qqclient.service;

import java.util.HashMap;

/**
 * @author Li Mi~
 * @version 1.0
 *
 * クライアントサイドがサーバーサイドに接続するスレッドを管理する
 */
public class ManageClientConnectServerThread {
    //マルチスレッドをHashMapコレクションに入れる、keyはユーザーID、valueはスレッドとして扱う
    private static HashMap<String, ClientConnectServerThread> hm = new HashMap<>();

    //スレッドをコレクションに入れる
    public static void addClientConnectServerThread(String userId, ClientConnectServerThread clientConnectServerThread) {
        hm.put(userId, clientConnectServerThread);
    }
    //userIdに通じて応じたスレッドを得る
    public static ClientConnectServerThread getClientConnectServerThread(String userId) {
        return hm.get(userId);
    }

}
