package 设计模式.设计模式分类.创建型.抽象工厂.Main;

import org.junit.Test;
import 设计模式.设计模式分类.创建型.工厂方法模式.Button;
import 设计模式.设计模式分类.创建型.抽象工厂.Action;
import 设计模式.设计模式分类.创建型.抽象工厂.factory.AbstractFactory;
import 设计模式.设计模式分类.创建型.抽象工厂.factory.FactoryProducer;

/**
 * @author Hujf
 * @title: test
 * @date 2021/3/1914:59
 * @description: TODO
 */
public class test {

    @Test
    public void t(){
        //创建了两种抽象工厂
        AbstractFactory bottonFactory = FactoryProducer.getFactory("Button");
        AbstractFactory actionFactory = FactoryProducer.getFactory("action");
        //创建了一个window工厂
        Button button = bottonFactory.getButton("window");
        button.onClick();
        Action action=actionFactory.getAction("start");
        action.toDoAction();
        Action action2=actionFactory.getAction("end");
        action2.toDoAction();
//        button.onClick();
      //  actionFactory.getAction()

    }
}
