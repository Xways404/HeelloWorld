package com.hspedu.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * @author Li Mi~
 * @version 1.0
 *
 * サーバーサイド
 */
public class SocketTCP03Server {
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
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);


        //socketに関連する出力ストリームを得る
        OutputStream outputStream = socket.getOutputStream();
        //charストリームで、出力ストリーム、データをデータルートに書き込む
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello client CHAR");
        bufferedWriter.newLine();//改行を差し込む、書き込まれた内容が終了したという表示
        bufferedWriter.flush();//charストリームを使うなら、手動で更新しなかん、でないとデータルートに書かれない
        //ソケットのストリームを無効
        socket.shutdownOutput();

        //ストリームとソケット、サーバーソケットを閉じる
        bufferedWriter.close();
        bufferedReader.close();
        outputStream.close();
        inputStream.close();
        serverSocket.close();
        socket.close();


    }
}
