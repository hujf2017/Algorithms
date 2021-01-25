package leecode;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Hujf
 * @title: le961
 * @date 2021/1/25 0025上午 9:28
 * @description: 重复一半
 */
public class le961 {

    public int repeatedNTimes(int[] A) {
        Set<Integer> a = new HashSet<>();

        for(int num:A){
            if(a.contains(num)){
                return num;
            }else {
                a.add(num);
            }
        }
        return  0;
    }

    @Test
    public void t(){
        repeatedNTimes(new int[]{1,2,3,3});
    }
}
