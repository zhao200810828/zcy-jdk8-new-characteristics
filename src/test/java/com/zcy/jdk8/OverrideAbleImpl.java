package com.zcy.jdk8;

/**
 * Created by sue on 2018/11/27.
 */
public class OverrideAbleImpl implements DefaultValue {
    @Override
    public String name() {
        return "kkkk";
    }

    @Override
    public String notRequired(){
        return "Overridden implementation";
    }
}
