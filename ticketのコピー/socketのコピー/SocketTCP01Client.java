package com.hspedu.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Li Mi~
 * @version 1.0
 *
 * クライアントサイドがサーバーサイドに"hello server"を送る
 */
public class SocketTCP01Client {
    public static void main(String[] args) throws IOException {

        //サーバーを接続する
        //この本体の9999ポートを接続する
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("クライサイドsocket戻し = " + socket.getClass());
        //接続できたら、Socketを形成、socket.getOutputStream()に通じて
        //socketオブジェクトの関連な出力ストリームオブジェクトを得る
        OutputStream outputStream = socket.getOutputStream();
        //出力ストリームに通じて、データをデータルートに書き込む
        outputStream.write("hello server".getBytes());
        //ソケットのストリームを無効
        socket.shutdownOutput();
        //socketに関連する入力ストリームを得て、読み取って(by byte)表示する
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buf)) != -1) {
            System.out.println(new String(buf,0,readLen));
        }



        //ストリームとソケットを閉じなけりゃ
        inputStream.close();
        outputStream.close();
        socket.close();
        System.out.println("クライアントサイドが退出・・・・");

    }
}
