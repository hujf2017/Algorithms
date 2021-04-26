package 基础.反射和动态代理;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Hujf
 * @title: BaseOnClass
 * @date 2021-04-26 9:49
 * @description: cglib  需要导入asm和cglib 包
 */



interface  BashInter{
     void addBook();
}

public class BaseOnClass implements BashInter{
    @Override
    public void addBook(){
        System.out.println("cglib@impl add book");
    }
}

class BookProxy2 implements MethodInterceptor {
    private Object object;

    public Object getInstance(Object o){
        this.object = o;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(object.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Before Advice");

        // 注意此处的参数是注入的objects 而不是o
        Object result = methodProxy.invoke(object, objects);
        System.out.println("After Advice");
        return result;
    }
}
