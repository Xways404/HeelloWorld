package com.hspedu.upload;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Li Mi~
 * @version 1.0
 *
 * ファイルアップロードのクライアントサイド
 */
public class TCPFileUploadClient {
    public static void main(String[] args) throws Exception {

        //クライアントが8888ポートに通じてサイドサーバーサイドに接続してソケットを得る
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        //ディスクファイルを読み取る入力ストリームを立ち上げ
        //２進制ファイルだから、BufferedInputStream、バイトストリームで作成しなかん
        String filePath = "/Users/xways404/bomb02.gif";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));

        //bytesはfilePathに応じたchar配列
        byte[] bytes = StreamUtils.streamToByteArray(bis);
        //socketに通じて入力ストリームを得て、bytesデータをサーバーサイドに
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes);//ファイルに応じたchar配列内容をデータルートに書き込む
        //ストリームを退出させる
        bis.close();
        socket.shutdownOutput();//ソケットのストリームを無効

        //サーバーサイドから返信されたメッセージを受け取る
        InputStream inputStream = socket.getInputStream();
        //StreamUtilsのメソッド使って、inputStreamで読み取った内容を文字列に変換する
        String s = StreamUtils.streamToString(inputStream);
        System.out.println(s);



        //
        bos.close();
        socket.close();
        inputStream.close();


    }
}
