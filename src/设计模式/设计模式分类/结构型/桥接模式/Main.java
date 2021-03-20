package 设计模式.设计模式分类.结构型.桥接模式;

import 设计模式.设计模式分类.结构型.桥接模式.Abstraction.Shape;
import 设计模式.设计模式分类.结构型.桥接模式.ConcreteImplementor.Color;
import 设计模式.设计模式分类.结构型.桥接模式.Implementor.Black;
import 设计模式.设计模式分类.结构型.桥接模式.Implementor.White;
import 设计模式.设计模式分类.结构型.桥接模式.RefinedAbstraction.Rectangle;
import 设计模式.设计模式分类.结构型.桥接模式.RefinedAbstraction.Square;

/**
 * @author Hujf
 * @title: Main
 * @date 2021/3/2015:32
 * @description: TODO
 */
public class Main {

    public static void main(String[] args) {
        //白色
        Color white = new White();
        //正方形
        Shape square = new Square();
        //白色的正方形
        square.setColor(white);
        square.draw();

        //长方形
        Shape rectange = new Rectangle();
        rectange.setColor(white);
        rectange.draw();

        Color black = new Black();
        square.setColor(black);
        square.draw();
    }
}
