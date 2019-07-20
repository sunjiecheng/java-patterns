package com.sjc.singleton;

/**
 * @author jiecheng
 * @create 2018-03-10 下午7:41
 * 懒汉式单例类.在第一次调用的时候实例化自己
 */
public class Lazy1 {
    //1、第一步先将构造方法私有化
    private Lazy1() {
    }

    //2、然后声明一个静态变量保存单例的引用
    private static Lazy1 single = null;

    //3、通过提供一个静态方法来获得单例的引用
    public static Lazy1 getInstance() {
        if (single == null) {
            single = new Lazy1();
        }
        return single;
    }
}

