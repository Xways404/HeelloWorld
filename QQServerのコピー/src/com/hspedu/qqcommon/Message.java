package com.hspedu.qqcommon;


import java.io.Serializable;

/**
 * @author Li Mi~
 * @version 1.0
 *
 * クライアントサイドとサーバーサイドが通信する際においてのメッセージオブジェクト
 */
public class Message implements Serializable {
    //互換性
    private static final long serialVersionUID = 1L;

    private String sender;//送信する側
    private String getter;//受信する側
    private String content;//メッセージ内容
    private String sendTime;//送信時間
    private String mesType;//メッセージのタイプ[インターフェースでメッセージのタイプを定義]

    //ファイルと関連するメンバーを拡張する
    private byte[] fileBytes;
    private int fileLen = 0;
    private String dest;//ファイルをどこへ
    private String src;//ソースファイルパス

    public byte[] getFileBytes() {
        return fileBytes;
    }

    public void setFileBytes(byte[] fileBytes) {
        this.fileBytes = fileBytes;
    }

    public int getFileLen() {
        return fileLen;
    }

    public void setFileLen(int fileLen) {
        this.fileLen = fileLen;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getMesType() {
        return mesType;
    }

    public void setMesType(String mesType) {
        this.mesType = mesType;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getGetter() {
        return getter;
    }

    public void setGetter(String getter) {
        this.getter = getter;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }
}
