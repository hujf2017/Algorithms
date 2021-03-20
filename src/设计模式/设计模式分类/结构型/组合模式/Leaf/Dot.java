package 设计模式.设计模式分类.结构型.组合模式.Leaf;

import 设计模式.设计模式分类.结构型.组合模式.Component.Graphic;

/**
 * @author Hujf
 * @title: Dot
 * @date 2021/3/2019:28
 * @description: TODO
 */
public class Dot implements Graphic {
    @Override
    public void move(int x, int y) {
        System.out.println();
    }

    @Override
    public void draw() {
        System.out.println("asdasd");
    }
}
