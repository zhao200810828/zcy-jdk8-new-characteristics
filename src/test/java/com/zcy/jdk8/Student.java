package com.zcy.jdk8;

/**
 * Created by sue on 2018/11/27.
 */
public class Student {
    String name;
    int score;

    public Student(String name,int score){
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
