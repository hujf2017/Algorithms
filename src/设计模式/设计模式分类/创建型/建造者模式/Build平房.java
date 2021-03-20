package 设计模式.设计模式分类.创建型.建造者模式;

import 设计模式.设计模式分类.创建型.建造者模式.Build.HouseBuilder;

/**
 * @author Hujf
 * @title: Build平房
 * @date 2021/3/2014:07
 * @description: TODO
 */
public class Build平房 implements HouseBuilder {
    @Override
    public void reset() {

    }

    @Override
    public void build地基() {
        System.out.println("太穷了 就建了一个地基");
    }

    @Override
    public void build楼房() {

    }

    @Override
    public void build院子() {

    }

    @Override
    public void build游泳池() {

    }

    @Override
    public void build地下车库() {

    }

    @Override
    public void build后花园() {

    }
}
