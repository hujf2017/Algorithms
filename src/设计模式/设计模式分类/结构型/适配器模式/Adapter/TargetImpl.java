package 设计模式.设计模式分类.结构型.适配器模式.Adapter;

import 设计模式.设计模式分类.结构型.适配器模式.Adaptee.Adaptee;
import 设计模式.设计模式分类.结构型.适配器模式.Target.Target;

/**
 * @author Hujf
 * @title: TargetImpl
 * @date 2021-05-29 9:56
 * @description: TODO
 */
public class TargetImpl  implements Target {


    public Adaptee getAdaptee() {
        return adaptee;
    }

    private Adaptee adaptee;
    @Override
    public void request() {
        System.out.println("新需求");
    }


    public void adapteeRequest() {
        adaptee.adapteeRequest();
    }


    public void newMethod(){

    }
}
