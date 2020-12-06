package 比赛;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Hujf
 * @title: le5618Khe
 * @date 2020/12/6 0006上午 11:18
 * @description: TODO
 */
public class le5618Khe {
    public int maxOperations(int[] nums, int k) {
        int num =0;
        Map<Integer,Integer> m = new HashMap();
        for(int s:nums){
            m.put(s,m.getOrDefault(s,0)+1);
        }
        for(int i:nums){
            if(m.getOrDefault(i,0)>0){
                m.put(i,m.get(i)-1);
            }else{
                continue;
            }
            if(m.getOrDefault(k-i,0)>0){
                m.put(k-i,m.get(k-i)-1);
            }else{
                continue;
            }
            num++;
        }
        return num;
    }
    @Test
    public void t(){
        maxOperations(new int[]{1,2,3,4},5);
    }
}
