package com.hspedu.ch19homework;

import java.io.File;
import java.io.IOException;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class HomeWork01 {
    public static void main(String[] args) throws IOException {

        String directoryPath = "/Users/xways404/mytemp";
        File file = new File(directoryPath);
        if (!file.exists()) {
            if (file.mkdirs()) {
                System.out.println("作成完了　" + directoryPath);

            } else {
                System.out.println("作成不能" + directoryPath);
            }
        }

        String filePath = directoryPath + "/hello.txt";
        file = new File(filePath);
        if (!file.exists()) {
            if (file.createNewFile()) {
                System.out.println(filePath + "作成完了");


            } else {
                System.out.println(filePath + "作成不能");
            }
        }


    }
}
