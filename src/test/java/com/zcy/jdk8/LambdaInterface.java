package com.zcy.jdk8;

/**
 * Created by sue on 2018/11/27.
 * 能使用lambda表达式的接口只有一个方法
 */
public interface LambdaInterface<T> {
    //测试git回退功能
    boolean test(T param);
}
