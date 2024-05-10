package com.hspedu.file;

import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class Directory_ {
    public static void main(String[] args) {

        //
    }

    ///Users/xways404/news1.txtがまだ既存しているかを判断する、いるなら削除する
    @Test
    public void m1() {
        String filePath = "/Users/xways404/news1.txt";
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println(filePath + "削除済み");
            } else {
                System.out.println(filePath + "削除不能");
            }
        } else {
            System.out.println("存在しない");
        }
    }

    ///Users/xways404/demo01がまだ存在しているか、いるなら削除する
    //javaプロセスでディレクトリがファイルとして扱える、
    @Test
    public void m2() {
        String filePath = "/Users/xways404/demo01";
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println(filePath + "削除済み");
            } else {
                System.out.println(filePath + "削除不能");
            }
        } else {
            System.out.println("このディレクトリ存在しない");
        }
    }

    // /Users/xways404/demo01ディレクトリが存在しているか、いるならいるで、出なけりゃ作成
    @Test
    public void m3() {
        String directoryPath = "/Users/xways404/demo01";
        File file = new File(directoryPath);
        if (file.exists()) {
            System.out.println(directoryPath + "ディレクトリの存在確認済み");
        } else {
            if (file.mkdirs()) {//上級ディレクトリを作成するにはmkdir()、多階層ディレクトリはmkdirsで
                System.out.println(directoryPath + "作成済み");
            } else {
                System.out.println(directoryPath + "作成不能");
            }
        }
    }
}
