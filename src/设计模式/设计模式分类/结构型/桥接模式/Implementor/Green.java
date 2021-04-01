package 设计模式.设计模式分类.结构型.桥接模式.Implementor;

import 设计模式.设计模式分类.结构型.桥接模式.ConcreteImplementor.Color;

/**
 * @author Hujf
 * @title: Green
 * @date 2021/3/2411:53
 * @description: TODO
 */
public class Green implements Color {
    @Override
    public void bepaint(String shape) {
        System.out.println("这是绿色的"+shape);
    }
}
