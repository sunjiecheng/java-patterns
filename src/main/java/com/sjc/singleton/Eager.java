package com.sjc.singleton;

/**
 * @author jiecheng
 * @create 2018-03-10 下午7:48
 * 饿汉式单例类.在类初始化时，已经自行实例化
 */
public class Eager {
    //1、 同样也是将默认构造方法私有化
    private Eager() {
    }

    //2、声明静态变量，在类实例化之前就初始化变量,将对象引用保存
    private static final Eager single = new Eager();

    //3、开放静态方法，获取实例
    public static Eager getInstance() {
        return single;

    }
}
