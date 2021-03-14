package common;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Hujf
 * @title: MyHashMap
 * @date 2021/3/1419:53
 * @description: TODO
 */
public class MyHashMap {


    private class Pair {
        private int key;
        private int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    private static final int BASE = 769;
    private LinkedList[] data;
    /** Initialize your data structure here. */
    public MyHashMap() {
        data = new LinkedList[BASE];
        for(int i=0;i<BASE;i++){
            data[i] = new LinkedList<Pair>();
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        //得到对应的映射
        int h = hash(key);
        //用一个迭代器 迭代链表
        Iterator<Pair> iterator = data[h].iterator();
        while(iterator.hasNext()){
            Pair pair = iterator.next();
            //如果得到值 之前有了 就重写
            if(pair.getKey()==key){
                pair.setValue(value);
                return;
            }
        }
        data[h].offerLast(new Pair(key, value));
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        //得到hash
        int h = hash(key);
        //去队列里得到队列
        Iterator<Pair> iterator =  data[h].iterator();
        while(iterator.hasNext()){
            Pair pair= iterator.next();
            if(pair.getKey()==key){
                return pair.value;
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        //得到hash
        int h = hash(key);
        Iterator<Pair> iterator = data[h].iterator();
        while(iterator.hasNext()){
            Pair pair =iterator.next();
            if(pair.getKey()==key){
                data[h].remove(pair);
                return ;
            }

        }
    }

    private static int hash(int key) {
        return key % BASE;
    }


    @Test
    public void t(){
        MyHashMap map  = new MyHashMap();
        map.put(2,50);
        map.put(72,30);
        System.out.println();
    }
}
