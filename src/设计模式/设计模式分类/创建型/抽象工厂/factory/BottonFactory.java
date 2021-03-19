package 设计模式.设计模式分类.创建型.抽象工厂.factory;

import 设计模式.设计模式分类.创建型.工厂方法模式.Button;
import 设计模式.设计模式分类.创建型.抽象工厂.Action;

/**
 * @author Hujf
 * @title: BottonFactory
 * @date 2021/3/1914:53
 * @description: TODO
 */
public class BottonFactory extends AbstractFactory{
    @Override
    public Action getAction(String aType) {
        return null;
    }

    @Override
    public Button getButton(String bType) {
        return null;
    }
}
