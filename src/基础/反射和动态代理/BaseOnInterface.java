package 基础.反射和动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Hujf
 * @title: BaseOnInterface
 * @date 2021-04-26 9:36
 * @description: TODO
 */

interface BookInterface{
    void addBook();

    void intercept();
}



public class BaseOnInterface implements  BookInterface{

    @Override
    public void addBook(){
        System.out.println("addbook");
    }

    @Override
    public void intercept(){
        System.out.println("intercept");
    }

}

class BookProxy implements InvocationHandler{

    private Object tar;

    public Object getIntance(Object o){
        this.tar = o;
        return Proxy.newProxyInstance(tar.getClass().getClassLoader(), tar.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before Advice");

        if("addBook".equals(method.getName())){
            System.out.println("执行方法");
            Object re= method.invoke(tar,args);
            System.out.println("After");
            return re;
        }else {
            System.out.println("is interrupt");
            return null;
        }
    }


}




