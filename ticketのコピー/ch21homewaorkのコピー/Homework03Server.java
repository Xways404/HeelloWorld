package com.hspedu.ch21homewaork;

import com.hspedu.upload.StreamUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class Homework03Server {
    public static void main(String[] args) throws Exception {

        //9999ポートでリスナーする
        ServerSocket serverSocket = new ServerSocket(9999);
        //サーバー接続待ち
        Socket socket = serverSocket.accept();
        //サーバーから発送されるダウンロードのファイル名を読み取る
        InputStream inputStream = socket.getInputStream();
        //byteストリーム配列に読み込む
        byte[] b = new byte[1024];
        int len = 0;
        String downLoadFileName = "";
        //ここでは繰り返し処理を行ってるけど、実際に必要ないんだが、今後クライアントサイドから大量なデータを受け取る可能性があるため
        while((len = inputStream.read(b)) != -1) {
            downLoadFileName += new String(b, 0, len);
        }
        System.out.println("クライアントサイドがダウンロードしたいファイル名＝　" + downLoadFileName);

        //bgm001.mp3 002
        //クライアントがダウンロードしたのが001であれば、001で戻す、でなけりゃ全部002で返す
        String resFileNme = "";
        //どのファイルなのかを判断するのじゃの
        if("002".equals(downLoadFileName)) {
            resFileNme = "src/bgm002.mp3";
        } else  {
            resFileNme = "src/bgm001.mp3";
        }
        //入力ストリームを立ち上げ、ファイルを読み取る
        BufferedInputStream bis =
                new BufferedInputStream(new FileInputStream(resFileNme));
        //ツールクラスStreamUtilsを使用して、ファイルをバイト入れsつに読み込む
        byte[] bytes = StreamUtils.streamToByteArray(bis);
        //ソケットに関連する出力ストリームを得る
        BufferedOutputStream bos =
                new BufferedOutputStream(socket.getOutputStream());
        //データルートに書き込み、クライアントに戻す
        bos.write(bytes);

        socket.shutdownOutput();//無効にしないといかん
        //ストリームを閉じる
        bis.close();
        bos.close();
        socket.close();
        inputStream.close();




    }
}
