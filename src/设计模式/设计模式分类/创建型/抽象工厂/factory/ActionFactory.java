package 设计模式.设计模式分类.创建型.抽象工厂.factory;

import 设计模式.设计模式分类.创建型.工厂方法模式.Button;
import 设计模式.设计模式分类.创建型.抽象工厂.Action;
import 设计模式.设计模式分类.创建型.抽象工厂.ShutdownAction;
import 设计模式.设计模式分类.创建型.抽象工厂.StartAction;

/**
 * @author Hujf
 * @title: ActionFactory
 * @date 2021/3/1914:55
 * @description: TODO
 */
public class ActionFactory extends AbstractFactory{
    @Override
    public Action getAction(String aType) {
        if(aType.equals("start")){
            return new StartAction();
        }else{
            return new ShutdownAction();
        }
    }

    @Override
    public Button getButton(String bType) {
        return null;
    }
}
