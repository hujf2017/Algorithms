package 设计模式.设计模式分类.结构型.适配器模式.test;

import org.junit.Test;
import 设计模式.设计模式分类.结构型.适配器模式.Adaptee.Adaptee;
import 设计模式.设计模式分类.结构型.适配器模式.Adapter.TargetImpl;
import 设计模式.设计模式分类.结构型.适配器模式.Target.Target;

/**
 * @author Hujf
 * @title: aaa
 * @date 2021-05-29 10:00
 * @description: TODO
 */
public class aaa {

    @Test
    public void t(){
        Adaptee target = new Adaptee();
        target.adapteeRequest();

        TargetImpl target1 = new TargetImpl();
        target1.request();
        target1.adapteeRequest();

    }
}
