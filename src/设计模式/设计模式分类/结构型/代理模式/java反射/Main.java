package 设计模式.设计模式分类.结构型.代理模式.java反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author Hujf
 * @title: Main
 * @date 2021-05-27 21:14
 * @description: TODO
 */
public class Main {
    public static void main(String[] args) throws Exception, InstantiationException, NoSuchMethodException {
        Class <?> clazz = null;
        clazz = DemoObj.class;
        System.out.println(clazz.getName());
        System.out.println(clazz.getSimpleName());

        System.out.println(Modifier.isPrivate(clazz.getModifiers()));

        Object obj =null;

        Constructor cons = clazz.getConstructor(String.class);
        obj = cons.newInstance("hello");
        //这个获取private会报错
        //Field key = clazz.getField("key");
        Field key = clazz.getDeclaredField("key");
        key.setAccessible(true);
        Object o = key.get(obj);
        System.out.println(o );

    }
}
