package leecode;


import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Hujf
 * @title: le705
 * @date 2021/3/139:28
 * @description: 自定义一个hashSet
 * 1.位置
 * 2.如果有重复的需要进行链表
 */
public class le705myHashSet {

    private List<LinkedList> a ;
    private int len = 13;
    public le705myHashSet(){
        a = new ArrayList<>();
        for(int i=0;i<len;i++){
            a.add(new LinkedList());
        }
    }

    public void add(int key){
        int num = key%len;
        LinkedList<Integer> linkedList =a.get(num);
        if(!linkedList.contains(key)){
            linkedList.add(key);
        }
    }

    public void remove(int key){
        int num = key%len;
        LinkedList<Integer> linkedList =a.get(num);
        if(linkedList.contains(key)){
            int index =linkedList.indexOf(key);
            linkedList.remove(index);
        }
    }

    public boolean contains(int key){
        int num = key%len;
        LinkedList<Integer> linkedList =a.get(num);
        return linkedList.contains(key);

    }

    @Test
    public void test(){
        le705myHashSet s = new le705myHashSet();
        s.add(1);
        s.remove(1);
    }
}
