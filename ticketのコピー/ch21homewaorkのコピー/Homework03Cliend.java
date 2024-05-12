package com.hspedu.ch21homewaork;

import jdk.nashorn.internal.ir.CallNode;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class Homework03Cliend {
    public static void main(String[] args) throws IOException {

        //ユーザーの入力を受け取る、ファイル名の指定
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please write the file name:");
        String downloadFileName = scanner.next();

        //クライアントサイドがサーバーに接続する準備をする
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        //ソケットと関連する出力ストリームを得る
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(downloadFileName.getBytes());
        socket.shutdownOutput();

        //サーバーに返されたファイルを読み取る
        BufferedInputStream bis = new BufferedInputStream((socket.getInputStream()));
        byte[] bytes = new byte[1024];
        //出力ストリームを得て、bytesをディスクに書き込む
        String filePath = "/Users/xways404/" + downloadFileName + ".mp3";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        bos.write(bytes);

        //ストリームを閉じる
        bos.close();
        bis.close();
        socket.close();
        outputStream.close();
        System.out.println("クライアントサイドのダウンロードが終了した");
    }
}
