package 设计模式.设计模式分类.结构型.代理模式.类的装载;

import com.sun.xml.internal.ws.util.StreamUtils;

import java.io.*;
import java.lang.reflect.Method;

/**
 * @author Hujf
 * @title: psvm
 * @date 2021-05-27 18:13
 * @description: TODO
 */
public class psvm {
    public static void main(String[] args) throws Exception  {
        MyClassLoader classLoader = new MyClassLoader();
        byte[] ba = new byte[1024];
        InputStream is = null;
        int r =0;
//
//        try {
//            is = new FileInputStream("E:\\java\\workspace\\myself\\Algorithms\\out\\test\\算法\\sum.class");
//            r= is.read(ba);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//            is.close();
//        }
//
//        classLoader.defineMyClass(null,ba,0,r);
        System.out.println(new File(".").getAbsolutePath());
        String s = "pat.num1001两数相加";
        Class<?> clazz = Class.forName(s);
       // Class<?> clazz = classLoader.loadClass("E:\\java\\workspace\\myself\\Algorithms\\src\\pat\\num1001两数相加.java");
        System.out.println(clazz.getCanonicalName());

        Object o = clazz.newInstance();

        Method m = clazz.getMethod("ttt");
        m.invoke(o);
    }
}
