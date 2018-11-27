package com.zcy.jdk8;

/**
 * Created by sue on 2018/11/27.
 * 默认方法不需要继承和实现
 */
public interface DefaultValue {

    /**
     * 该方法必须实现
     * @return
     */
    String name();

    /**
     * 该默认方法不需要实现，可以重写
     * @return
     */
    default String notRequired(){
        return "Defaulf Implementation";
    }
}
