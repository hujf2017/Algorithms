package 设计模式.设计模式分类.创建型.抽象工厂.factory;

import 设计模式.设计模式分类.创建型.工厂方法模式.Button;
import 设计模式.设计模式分类.创建型.抽象工厂.Action;

/**
 * @author Hujf
 * @title: AbstractFactory
 * @date 2021/3/1914:51
 * @description: TODO
 */
public abstract class AbstractFactory {

    public abstract Action getAction(String aType);
    public abstract Button getButton(String bType);
}
