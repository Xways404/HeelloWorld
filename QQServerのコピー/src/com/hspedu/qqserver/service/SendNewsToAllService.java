package com.hspedu.qqserver.service;

import com.hspedu.qqcommon.Message;
import com.hspedu.qqcommon.MessageType;
import com.hspedu.utils.Utility;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class SendNewsToAllService implements Runnable {

    @Override
    public void run() {

        //繰り返してニュース発信するため、whileで
        while (true) {
            System.out.println("サーバーが発信したいニュースを入力してな・・exit is getout・・");
            String news = Utility.readString(100);
            if("exit".equals(news)){
                break;
            }
            //メッセージを構築、グループメッセージ
            Message message = new Message();
            message.setSender("サーバー");
            message.setMesType(MessageType.MESSAGE_TO_ALL_MES);
            message.setContent(news);
            message.setSendTime(new Date().toString());
            System.out.println("サーバーがメッセージを全員に送信：　" + news);

            //全ての通信スレッドを走査して、ソケットをゲットし、messageを発送
            HashMap<String, ServerConnectClientThread> hm = ManageClientThreads.getHm();

            Iterator<String> iterator = hm.keySet().iterator();
            while (iterator.hasNext()) {
                String onLineUserId = iterator.next().toString();
                try {
                    ObjectOutputStream oos =
                            new ObjectOutputStream(hm.get(onLineUserId).getSocket().getOutputStream());
                    oos.writeObject(message);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


            }
        }

    }
}
