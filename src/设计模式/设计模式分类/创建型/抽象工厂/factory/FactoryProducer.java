package 设计模式.设计模式分类.创建型.抽象工厂.factory;

import 设计模式.设计模式分类.创建型.工厂方法模式.factory.ButtonFacoty;

/**
 * @author Hujf
 * @title: FactoryProducer
 * @date 2021/3/1914:56
 * @description: TODO
 */
public class FactoryProducer {

    //这里是抽象类 所以必须是由他的子类所构成的
    public static AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("Button")){
            return new BottonFactory();
        } else {
            return new ActionFactory();
        }
    }
}
