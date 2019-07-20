package com.sjc.singleton;

/**
 * @author jiecheng
 * @create 2018-03-10 下午7:43
 * 懒汉式单例.保证线程安全
 */
public class Lazy2 {

    //1、第一步先将构造方法私有化
    private Lazy2() {
    }

    //2、然后声明一个静态变量保存单例的引用
    private static Lazy2 single = null;

    //3、通过提供一个静态方法来获得单例的引用
    //为了保证多线程环境下正确访问，给方法加上同步锁synchronized
    public static synchronized Lazy2 getInstance() {
        if (single == null) {
            single = new Lazy2();
        }
        return single;
    }

}
