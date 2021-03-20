package 设计模式.设计模式分类.结构型.桥接模式.RefinedAbstraction;

import 设计模式.设计模式分类.结构型.桥接模式.Abstraction.Shape;

public class Circle extends Shape {
 
    @Override
    public void draw() {
        color.bepaint("正方形");
    }
}