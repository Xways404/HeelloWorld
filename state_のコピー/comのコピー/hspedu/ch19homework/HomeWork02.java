package com.hspedu.ch19homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class HomeWork02 {
    public static void main(String[] args) {

        String filePath = "/Users/xways404/mytemp/hello.txt";
        BufferedReader br = null;
        String line = null;
        int lineNum = 0;
        try {
            br = new BufferedReader(new FileReader(filePath));
            while((line = br.readLine()) != null) {
                System.out.println(++lineNum + line);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }


    }
}
