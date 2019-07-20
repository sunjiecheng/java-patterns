package com.sjc.singleton.register;


import java.util.HashMap;
import java.util.Map;

/**
 * 类似Spring里面的方法，将类名注册，下次从里面直接获取。
 */
public class RegSingleton {
    private static Map<String, RegSingleton> map = new HashMap<String, RegSingleton>();

    static {
        RegSingleton single = new RegSingleton();
        map.put(single.getClass().getName(), single);
    }

    //保护的默认构造子
    protected RegSingleton() {
    }

    //静态工厂方法,返还此类惟一的实例
    public static RegSingleton getInstance(String name) {
        if (name == null) {
            name = RegSingleton.class.getName();
        }
        if (map.get(name) == null)

        {
            try {
                map.put(name, (RegSingleton) Class.forName(name).newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return map.get(name);
    }
}

