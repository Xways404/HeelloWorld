package com.hspedu.inputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class FileInPutStream {
    public static void main(String[] args) {

    }
    public void readFile01() {
    String filePath = "asdfsads";
    int readDate = 0;

        try {
            FileInputStream fileInputStream =new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
        }
    }
}
