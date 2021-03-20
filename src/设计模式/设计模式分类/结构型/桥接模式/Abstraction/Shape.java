package 设计模式.设计模式分类.结构型.桥接模式.Abstraction;

import 设计模式.设计模式分类.结构型.桥接模式.ConcreteImplementor.Color;

/**
 * @author Hujf
 * @title: Shape
 * @date 2021/3/2015:34
 * @description: TODO
 */
public abstract class Shape {
    public Color color;

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract void draw();
}
