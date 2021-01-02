package 基础.集合;

import org.junit.Test;

import java.util.*;

/**
 * @author Hujf
 * @title: SetTest
 * @date 2020/12/31 0031上午 10:29
 * @description: TODO
 */
public class SetTest {

    @Test
    public void t(){
        List s = new LinkedList();
        for(int i=1;i<=100;i++){
            s.add(i);
        }

        while(s.size()>0){
            int num = (int)(Math.random()*s.size());
            System.out.println(s.get(num));
            s.remove(num);
        }
        System.out.println("结束");
    }

    @Test
    public void t2(){
        Set s = new LinkedHashSet();
        for(int i=1;i<=100;i++){
            s.add(i);
        }

        while(s.size()>0){
            int num = (int)(Math.random()*s.size());
            System.out.println(s);
            s.remove(num);
        }
        System.out.println("结束");
    }
}
