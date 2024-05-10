package com.hspedu.file;

import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class FileInformation {
    public static void main(String[] args) {

    }
    @Test
    //ファイルのインフォを入手
    public void info() {
        //ファイルオブジェクトを作成
        File file = new File("/Users/xways404/news1.txt");

        //応じたメソッドをコールして、適応なインフォを入手
        System.out.println("File Name: " + file.getName());
        //絶対パスをゲット
        System.out.println("ファイルの絶対パス = " + file.getAbsolutePath());
        System.out.println("ファイル親ディレクトリ = " + file.getParent());
        System.out.println("ファイルの大きさ(byte)  = " + file.length());
        System.out.println("ファイル存在確認 = " + file.exists());
        System.out.println("ファイルなのか　= " + file.isFile());
        System.out.println("ディレクトリなのか = " + file.isDirectory());

    }
}
