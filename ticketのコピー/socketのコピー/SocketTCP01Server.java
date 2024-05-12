package com.hspedu.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * @author Li Mi~
 * @version 1.0
 *
 * サーバーサイド
 */
public class SocketTCP01Server {
    public static void main(String[] args) throws IOException {

        //本体の9999でリスナーする
        //本体で他のものが9999をリスナーしていないと限る
        //serverSocketがaccept()メソッドに通じて、多数のSocketが戻される
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("サーバーサイドがポートでリスナーしてる///////");
        //クライアントサイドが9999ポートを接続していない時
        //もしクライアントサイドが接続していれば、、Socketオブジェクトが戻され、プログラミング継続
        Socket socket = serverSocket.accept();

        System.out.println("サーバーサイドsocket = " + serverSocket.getClass());
        // socket.getInputStream()に通じてクライアントサイドがデータルートに書き込んだデータを読み取る
        InputStream inputStream = socket.getInputStream();
        //IOストリームの読み取り
        byte[] buf = new byte[1024];
        int readLen  = 0;
        while ((readLen = inputStream.read(buf)) != -1) {
            System.out.println(new String(buf,0, readLen));//実際に読み取った長さで、内容を表示する
        }

        //socketに関連する出力ストリームを得る
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello client".getBytes());
        //ソケットのストリームを無効
        socket.shutdownOutput();


        //ストリームとソケット、サーバーソケットを閉じる
        inputStream.close();
        serverSocket.close();
        socket.close();


    }
}
