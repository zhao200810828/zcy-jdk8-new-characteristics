package com.zcy.jdk8;

import java.util.function.Supplier;

/**
 * Created by sue on 2018/11/27.
 * 该类测试默认接口生成工厂
 */
public interface DefaulableFactory {
    // Interfaces now allow static methods
    static DefaultValue create( Supplier<DefaultValue> supplier ) {
        return supplier.get();
    }
}
