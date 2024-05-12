package com.hspedu.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author Li Mi~
 * @version 1.0
 *
 * クライアントサイドがサーバーサイドに"hello server"を送る
 */
public class SocketTCP03Client {
    public static void main(String[] args) throws IOException {

        //サーバーを接続する
        //この本体の9999ポートを接続する
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("クライサイドsocket戻し = " + socket.getClass());
        //接続できたら、Socketを形成、socket.getOutputStream()に通じて
        //socketオブジェクトの関連な出力ストリームオブジェクトを得る
        OutputStream outputStream = socket.getOutputStream();
        //出力ストリームに通じて、データをデータルートに書き込む
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello sever CHar");
        bufferedWriter.newLine();
        bufferedWriter.flush();
//        //ソケットのストリームを無効
//        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);


        //ストリームとソケットを閉じなけりゃ
        bufferedReader.close();
        bufferedWriter.close();
        outputStream.close();
        socket.close();
        System.out.println("クライアントサイドが退出・・・・");

    }
}
