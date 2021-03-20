package 设计模式.设计模式分类.结构型.组合模式.Container;

import 设计模式.设计模式分类.结构型.组合模式.Component.Graphic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hujf
 * @title: CompoundGraphic
 * @date 2021/3/2019:29
 * @description: TODO
 */
public class CompoundGraphic implements Graphic {

    List<Graphic> graphicList;

    public CompoundGraphic() {
        graphicList = new ArrayList<Graphic>();
    }

    public void add(Graphic graphic){
        graphicList.add(graphic);
    }

    public void remove(Graphic graphic){
        graphicList.remove(graphic);
    }

    @Override
    public void move(int x, int y) {

    }

    @Override
    public void draw() {
        for(Graphic gx:graphicList){
            gx.draw();
        }
    }
}
