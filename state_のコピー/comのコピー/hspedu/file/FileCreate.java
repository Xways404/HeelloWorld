package com.hspedu.file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class FileCreate {
    public static void main(String[] args) {

    }

    //方式１：new File(String pathname)
    @Test
    public void create01() {
        String filePath = "/Users/xways404/news1.txt";
        File file = new File(filePath);

        try {
            file.createNewFile();
            System.out.println("you got createNewFile");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //方式２　new File(File parent ,String child) //親子ファイルで構築
    // /Users/xways404/news1.txt
    @Test
    public void create02() {
        File parentFile = new File("/Users/xways404/");
        String fileName = "news2.txt";
        //ここのfileオブジェクト、javaのプロセスでは、ただのオブジェクトである
        //createNewFileメソッドを実行してから、本当にファイル作成される
        File file = new File(parentFile, fileName);

        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    //方式３ new File(String parent, String child) //親のカタログ＋子パスで構築
    public void create03() {
        String parentPath = "/Users/xways404/";
        String fileName = "news3.txt";
        File file = new File(parentPath, fileName);

        try {
            file.createNewFile();
            System.out.println("you got createNewFile");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

