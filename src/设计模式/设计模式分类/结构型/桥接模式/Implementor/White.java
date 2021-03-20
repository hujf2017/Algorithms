package 设计模式.设计模式分类.结构型.桥接模式.Implementor;

import 设计模式.设计模式分类.结构型.桥接模式.ConcreteImplementor.Color;

public class White implements Color {

    @Override
    public void bepaint(String shape) {
        System.out.println("白色的" + shape);
    }

}