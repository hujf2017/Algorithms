package 基础.双亲委派.test;

import java.lang.reflect.Method;

/**
 * @Author hujf
 * @Date 2022/6/21 16:32
 * @Description TODO
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        myclassloader myclassload = new myclassloader();
        Class acla = myclassload.findClass("MyClass.Demo");
        Object obj  = null;
        try {
            obj = acla.newInstance();
            Method method = acla.getMethod("say");
            method.invoke(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
