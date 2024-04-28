package com.hspedu.static_;

public class CodeBlock {
    public static void main(String[] args) {
        movie nima = new movie(5432);

    }
}
class movie {
    private int name;
    private String director;
    private int year;
    {
        System.out.println("君の膵臓を食う");
        System.out.println("hadjada");
        System.out.println("shut fxxkup");
    }
    public movie(int name) {
        this.name = name;
    }

    public movie(int name, String director) {
        this.name = name;
        this.director = director;
    }

    public movie(int name, String director, int year) {
        this.name = name;
        this.director = director;
        this.year = year;
    }
}
