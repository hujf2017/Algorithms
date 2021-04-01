package 设计模式.设计模式分类.结构型.组合模式;

import org.junit.Test;
import 设计模式.设计模式分类.结构型.组合模式.Container.CompoundGraphic;
import 设计模式.设计模式分类.结构型.组合模式.Leaf.Circle;
import 设计模式.设计模式分类.结构型.组合模式.Leaf.Dot;
import 设计模式.设计模式分类.结构型.组合模式.Leaf.Regular;

import java.util.*;

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

    @Test
    public void t2(){
        Map<Integer,Integer> m = new HashMap();
        m.put(1,2);
        m.put(2,3);
        for(Map.Entry entry:m.entrySet()){
            System.out.print(entry.getKey()+" ");
            System.out.println(entry.getValue());
        }

        Map<Integer,Integer> m2= new HashMap();
        m2.put(3,4);
        m.putAll(m2);
        for(Map.Entry entry:m.entrySet()){
            System.out.print(entry.getKey()+" ");
            System.out.println(entry.getValue());
        }
    }
    @Test
    public void t3(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        for(int num:list){
            System.out.println(num);
        }

        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list.addAll(list2);
        for(int num:list){
            System.out.println(num);
        }
    }


}
