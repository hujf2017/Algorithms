package 设计模式.设计模式分类.创建型.建造者模式.Director;

import 设计模式.设计模式分类.创建型.建造者模式.Build.HouseBuilder;

/**
 * @author Hujf
 * @title: HouseDirector
 * @date 2021/3/2014:13
 * @description: TODO
 */
public class HouseDirector {

    private HouseBuilder builder;

    public HouseDirector(HouseBuilder builder){
        this.builder = builder;
    }

    public void construct(){
        builder.build后花园();
        builder.build地下车库();
        builder.build地基();
        builder.build楼房();
    }
}
