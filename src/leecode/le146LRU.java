package leecode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Hujf
 * @title: le146LRU
 * @date 2021-04-2417:43
 * @description: TODO
 */
public class le146LRU extends LinkedHashMap<Integer,Integer>{

    private int capacity;

    public le146LRU(int capacity) {
        super(capacity, 0.75F,true);
        this.capacity =capacity;
    }

    @Override
    public Integer get(Object key) {
        return super.getOrDefault(key,-1);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size()>capacity;
    }

    public static void main(String[] args) {
        le146LRU l = new le146LRU(2);
        l.put(1,1);
        l.put(2,2);
        l.get(1);
        l.put(3,3);
        System.out.println(l.get(2));
    }
}
