package com.sjc.proxy.reflect;

import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.lang.reflect.Method;
import java.util.Vector;
import java.util.List;

public class VectorProxy implements InvocationHandler {
    private Object proxyobj;

    /**
     * @link dependency
     */
    /*#Proxy lnkProxy;*/
    public VectorProxy(Object obj) {
        proxyobj = obj;
    }

    public static Object factory(Object obj) {
        Class cls = obj.getClass();

        return Proxy.newProxyInstance(cls.getClassLoader(),
                cls.getInterfaces(),
                new VectorProxy(obj));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before calling " + method);

        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                System.out.println(args[i] + "");
            }
        }

        Object o = method.invoke(proxyobj, args);

        System.out.println("after calling " + method);

        return o;
    }

    public static void main(String[] args) {
        List v = null;

        v = (List) factory(new Vector(10));
        writeProxyToFile();
        v.add("New");
        v.add("York");

        System.out.println(v.get(0));
    }

    public static void writeProxyToFile() {
        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0", Vector.class.getInterfaces());
        String path = "proxy.class";
        try(FileOutputStream fos = new FileOutputStream(path)) {
            fos.write(classFile);
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}