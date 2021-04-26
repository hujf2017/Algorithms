package 基础.反射和动态代理;

import org.junit.Test;

/**
 * @author Hujf
 * @title: test
 * @date 2021-04-26 9:46
 * @description: TODO
 */
public class test {

    @Test
    public void t(){
        BookProxy bookProxy = new BookProxy();
        BookInterface intance = (BookInterface) bookProxy.getIntance(new BaseOnInterface());
        intance.addBook();
    }


    @Test
    public void t2(){
        BookProxy2 bookProxy2 = new BookProxy2();
        BaseOnClass instance = (BaseOnClass) bookProxy2.getInstance(new BaseOnClass());
        instance.addBook();
    }
}
