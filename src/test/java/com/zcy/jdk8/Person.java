package com.zcy.jdk8;

/**
 * Created by sue on 2018/11/28.
 */
public class Person {
    public int no;
    private String name;
    private int age;
    public Person (int no, String name) {
        this.no = no;
        this.name = name;
    }
    public Person (int no, String name,int age) {
        this.no = no;
        this.name = name;
        this.age = age;
    }
    public String getName() {
        System.out.println(name);
        return name;
    }
    public int getAge(){
        return this.age;
    }
}
