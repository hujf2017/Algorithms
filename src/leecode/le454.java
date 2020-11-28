package leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hujf
 * @title: le454
 * @date 2020/11/27 0027上午 9:18
 * @description: TODO
 */
public class le454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> countAB = new HashMap<Integer, Integer>();
        for(int u:A){
            for(int v:B){
                countAB.put(u+v,countAB.getOrDefault(u+v,0)+1);
            }
        }
        int count =0;
        for(int u:C){
            for(int v:D){
                if(countAB.containsKey(-u-v)){
                    count +=countAB.get(-u-v);
                }
            }
        }
        return count;
    }
}
