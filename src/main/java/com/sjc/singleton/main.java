package com.sjc.singleton;

/**
 * @author jiecheng
 * @create 2018-03-11 上午1:04
 */
public class main {
    public static void main(String[] args) {
        Class<Integer> integerClass = int.class;
        Class<Integer> integerClass1 = Integer.class;
        Class<Void> voidClass = void.class;
        System.out.println(voidClass.isPrimitive());
        System.out.println(integerClass.isPrimitive());
        System.out.println(integerClass.isPrimitive());
        System.out.println(int.class == Integer.TYPE);
    }
}
