package com.hspedu.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class UDPReceiverA {
    public static void main(String[] args) throws IOException {
        //DatagramSocketオブジェクトを立ち上げ、9999ポートでデータを受け取る
        DatagramSocket socket = new DatagramSocket(9999);
        //DatagramPacketオブジェクトを構築して、データを受け取る準備をする
        //UDPのプロトロルでははパケットの容量は64k
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        //受け取るメソッドをコール
        //ネットワークに通じて伝送されたDatagramPacketオブジェクトがpacketに埋める
        System.out.println("i m waiting");
        socket.receive(packet);

        //packetを開けて、中のデータを取り出して表示する
        int length = packet.getLength();//読み取ったデータの長さ
        byte[] data = packet.getData();//受け取ったデータ

        String s = new String(data, 0, length);
        System.out.println(s);

        //発送する必要があるデータをDatagramPacketオブジェクトにカプセルする
        data = "see you".getBytes();
        //
        packet =
                new DatagramPacket(data, data.length, InetAddress.getByName("192.168.1.16"), 9998);

        socket.send(packet);

        socket.close();
        System.out.println("getout A");



    }
}
