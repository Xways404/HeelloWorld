package com.hspedu.api;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Li Mi~
 * @version 1.0
 *
 * InetAddressの使用
 */
public class API_ {
    public static void main(String[] args) throws UnknownHostException {

        //このコンピュータのInetAddressオブジェクトを取得
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);

        //指定されたパソコンの本体に基づき、InetAddressオブジェクトを取得
        InetAddress byName = InetAddress.getByName("rimitsunoMacBook-Pro.local");
        System.out.println(byName);

        //ドメインに基づき、InetAddressオブジェクトを取得
        InetAddress byName1 = InetAddress.getByName("www.google.com");
        System.out.println(byName1);

        //InetAddressオブジェクトに通じて、応じたアドレスを取得
        String address = byName1.getHostAddress();
        System.out.println(address);

        //InetAddressオブジェクトに通じて、パソコン本体名かドメイン名を取得
        String hostName = byName1.getHostName();
        System.out.println(hostName);

    }
}
