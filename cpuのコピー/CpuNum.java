package com.hshedu.cpu;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class CpuNum {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        //CPUの情報を可視化
        int cpuNum = runtime.availableProcessors();
        System.out.println("This Mac's CPU " + cpuNum);

    }
}
