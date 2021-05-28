package 设计模式.设计模式分类.结构型.代理模式.类的装载;

/**
 * @author Hujf
 * @title: MyClassLoader
 * @date 2021-05-27 18:10
 * @description: TODO
 */
public class MyClassLoader extends ClassLoader{
    public Class<?> defineMyClass(String name,byte[] b,int off,int len){
        return super.defineClass(name,b,off,len);
    }
}
