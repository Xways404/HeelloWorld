package com.hspedu.qqcommon;

/**
 * @author Li Mi~
 * @version 1.0
 *
 * メッセージのタイプを表示
 */
public interface MessageType {
    //インターフェースで定数を定義
    //それぞれ定数の値が、それぞれのメッセージタイプを表示
    String MESSAGE_LOGIN_SUCCEED = "1";//ログイン完了
    String MESSAGE_LOGIN_FAIL = "2";//ログイン失敗
    String MESSAGE_COMM_MES = "3";//一般メッセージパッケージ
    String MESSAGE_GET_ONLINE_FRIEND = "4";//オンラインユーザーリストを戻す
    String MESSAGE_RET_ONLINE_FRIEND = "5";//戻されたオンラインユーザーリスト
    String MESSAGE_CLIENT_EXIT = "6";//クライアントサイドが退出リクエストを出した
    String MESSAGE_TO_ALL_MES = "7";
    String MESSAGE_FILE_MES = "8";//ファイルメッセージ



}
