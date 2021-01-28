package leecode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Hujf
 * @title: MyHashSet
 * @date 2021/1/28 0028上午 8:57
 * @description: TODO
 */
public class MyHashSet {

    HashMap map ;
    /** Initialize your data structure here. */
    public MyHashSet() {
        map = new HashMap();
    }

    public void add(int key) {
        map.put(key,0);
    }

    public void remove(int key) {
        map.remove(key);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return map.containsKey(key);
    }

}
