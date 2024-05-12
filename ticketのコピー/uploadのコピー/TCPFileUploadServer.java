package com.hspedu.upload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Li Mi~
 * @version 1.0
 *
 * ファイルアップロードのサーバーサイド
 */
public class TCPFileUploadServer {
    public static void main(String[] args) throws Exception {

        //サーバーサイドに本体で8888ポートをリスナーさせる
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("サーバーサイドが8888ポートでリスナーしてるぞ・・・・");
        //接続待ち
        Socket socket = serverSocket.accept();

        //クライアントが送信したデータを読み取る
        //Socketで入力ストリームを得る
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        //読み取る by StreamUtils
        byte[] bytes = StreamUtils.streamToByteArray(bis);
        //得たbytes配列を、指定されたルートに書き込む、ファイルをゲット
        //パス定義
        String destFilePath = "src/bomb22.gif";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFilePath));
        bos.write(bytes);
        bos.close();

        //クライアントに「イメージ図が到着した」と返信する
        //ソケットに通じて出力ストリームを得る
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.write("もらったぜ・・・・・・");
        writer.flush();//内容をデータルートに更新する
        socket.shutdownOutput();//ソケットを無効にする

        //
        bis.close();
        socket.close();
        writer.close();




    }
}
