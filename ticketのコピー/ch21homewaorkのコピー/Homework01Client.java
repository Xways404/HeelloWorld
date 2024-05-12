package com.hspedu.ch21homewaork;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class Homework01Client {
    public static void main(String[] args) throws IOException {

        //サーバーを接続する
        //この本体の9999ポートを接続する
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        //接続できたら、Socketを形成、socket.getOutputStream()に通じて
        //socketオブジェクトの関連な出力ストリームオブジェクトを得る
        OutputStream outputStream = socket.getOutputStream();
        //出力ストリームに通じて、データをデータルートに書き込む
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

        //キーボードからユーザーの質問読み取る　
        Scanner scanner = new Scanner(System.in);
        System.out.println("write your Q");
        String question = scanner.next();


        bufferedWriter.write(question);
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
