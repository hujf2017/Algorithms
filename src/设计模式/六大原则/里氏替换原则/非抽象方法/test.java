package 设计模式.六大原则.里氏替换原则.非抽象方法;

import org.junit.Test;

/**
 * @author Hujf
 * @title: test
 * @date 2021/3/1517:13
 * @description: TODO
 */
public class test {

    public void resize(长方形 c){
        //对于正方形 会一直在这里面循环 所以就有问题了  正方形实现父类的非抽象方法时 参数要求需要更加宽松 而抽象方法恰恰相反 需要更严格
        while(c.getWigth()<=c.getHeight()){
            c.setWigth(c.getHeight()+1);
        }
        System.out.println(c.getHeight()+" "+c.getWigth());

    }

    @Test
    public void t(){
        长方形 r=new 长方形();
        r.setHeight(15);
        r.setWigth(5);

        正方形 z= new 正方形();
        z.setHeight(15);
        z.setWigth(5);

        test t = new test();
        t.resize(r);
        t.resize(z);

    }
}
