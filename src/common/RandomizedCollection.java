package common;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Hujf
 * @title: RandomizedCollection
 * @date 2020/10/31 0031上午 9:03
 * @description: TODO
 */
public class RandomizedCollection {

    public   List<Integer> list = new ArrayList();

    /** Initialize your data structure here. */
    public RandomizedCollection() {

    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if(list.indexOf(val)==-1){
            list.add(val);
            return true;
        }else{
            list.add(val);
            return false;
        }



    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        int i = list.indexOf(val);
        if(i==-1){
            return false;
        }else{
            list.remove(list.indexOf(val));
            return true;
        }
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        int k = list.size();
        int i = (int) (Math.random()*k);
        return list.get(i);
    }
}
