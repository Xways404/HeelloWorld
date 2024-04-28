package com.hspedu.static_.abstract_;

abstract public class Template {
    public abstract void job();
    public void calculateTime() {
        long start = System.currentTimeMillis();
        job();
        long end = System.currentTimeMillis();
        System.out.println("assignment実行タイム " + (end - start));
    }
}
