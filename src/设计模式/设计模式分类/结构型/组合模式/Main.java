package 设计模式.设计模式分类.结构型.组合模式;

import org.junit.Test;
import 设计模式.设计模式分类.结构型.组合模式.Container.CompoundGraphic;
import 设计模式.设计模式分类.结构型.组合模式.Leaf.Circle;
import 设计模式.设计模式分类.结构型.组合模式.Leaf.Dot;
import 设计模式.设计模式分类.结构型.组合模式.Leaf.Regular;

/**
 * @author Hujf
 * @title: Main
 * @date 2021/3/2021:08
 * @description: TODO
 */
public class Main {

    @Test
    public void t(){
        CompoundGraphic g = new CompoundGraphic();
        g.add(new Dot());
        g.add(new Circle());
        g.add(new Regular());

        g.draw();
    }
}
