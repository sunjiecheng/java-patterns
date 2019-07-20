package com.sjc.singleton;

/**
 * @author jiecheng
 * @create 2018-03-10 下午7:45
 * 懒汉式单例.双重锁检查
 */
public class Lazy3 {
    //1、第一步先将构造方法私有化
    private Lazy3() {
    }

    //2、然后声明一个静态变量保存单例的引用
    private static Lazy3 single = null;

    //3、通过提供一个静态方法来获得单例的引用
//为了保证多线程环境下的另一种实现方式，双重锁检查
    public static Lazy3 getInstance() {
        if (single == null) {
            synchronized (Lazy3.class) {
                if (single == null) {
                    single = new Lazy3();
                }
            }
        }
        return single;
    }

}
