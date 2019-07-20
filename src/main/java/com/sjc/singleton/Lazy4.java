package com.sjc.singleton;

/**
 * @author jiecheng
 * @create 2018-03-10 下午7:46
 * 懒汉式（静态内部类）
 */
public class Lazy4 {
    //1、先声明一个静态内部类
    private static class LazyHolder {
        private static final Lazy4 INSTANCE = new Lazy4();
    }

    //2、将默认构造方法私有化
    private Lazy4() {
    }

    //3、同样提供静态方法获取实例
    public static final Lazy4 getInstance() {
        return LazyHolder.INSTANCE;
    }

}
