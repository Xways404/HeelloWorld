package com.hspedu.static_.abstract_;


public class AA extends Template{

//    public void calculateTime() {
//        long start = System.currentTimeMillis();
//        job();
//        long end = System.currentTimeMillis();
//        System.out.println("AA実行タイム " + (end - start));
//    }

    public void job() {
//        long start = System.currentTimeMillis();
        long num = 0;
        for(long i = 0; i < 2100000; i++) {
            num *= 1;
        }
//        long end = System.currentTimeMillis();
//        System.out.println("AA実行タイム " + (end - start));

    }
}
