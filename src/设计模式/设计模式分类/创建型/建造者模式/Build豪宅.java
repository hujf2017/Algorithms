package 设计模式.设计模式分类.创建型.建造者模式;

import 设计模式.设计模式分类.创建型.建造者模式.Build.HouseBuilder;

/**
 * @author Hujf
 * @title: Build豪宅
 * @date 2021/3/2014:08
 * @description: TODO
 */
public class Build豪宅 implements HouseBuilder {
    @Override
    public void reset() {

    }

    @Override
    public void build地基() {
        System.out.println("我全都要");
    }

    @Override
    public void build楼房() {
        System.out.println("我全都要");
    }

    @Override
    public void build院子() {
        System.out.println("我全都要");
    }

    @Override
    public void build游泳池() {
        System.out.println("我全都要");
    }

    @Override
    public void build地下车库() {
        System.out.println("我全都要");
    }

    @Override
    public void build后花园() {
        System.out.println("我全都要");
    }
}
