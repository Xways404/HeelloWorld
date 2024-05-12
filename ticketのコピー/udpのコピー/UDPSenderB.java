package com.hspedu.udp;

import java.io.IOException;
import java.net.*;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class UDPSenderB {
    public static void main(String[] args) throws IOException {

        //DatagramSocketオブジェクトを立ち上げ、受取と送信されたデータを準備する
        DatagramSocket socket = new DatagramSocket(9998);

        //発送する必要があるデータをDatagramPacketオブジェクトにカプセルする
        byte[] data = "hello world".getBytes();
        //
        DatagramPacket packet =
                new DatagramPacket(data, data.length, InetAddress.getByName("192.168.1.16"), 9999);

        socket.send(packet);

        byte[] buf = new byte[1024];
        packet = new DatagramPacket(buf, buf.length);
        //受け取るメソッドをコール
        //ネットワークに通じて伝送されたDatagramPacketオブジェクトがpacketに埋める
        socket.receive(packet);
        int length = packet.getLength();
        data = packet.getData();
        String s = new String(data, 0, length);
        System.out.println(s);

        socket.close();
        System.out.println("getout B");


    }
}
