package leecode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Hujf
 * @title: le697
 * @date 2021/2/20 0020上午 9:41
 * @description: TODO
 */
public class le697 {
    public int findShortestSubArray(int[] nums) {
        //记录每个字符出现的第一个 和最后一个为止
        //记录每个字符出现的次数
        //得到最大的一类字符
        //求其第一个和最后一个的距离
        boolean []a = new boolean[50000];
        int []start = new int[50000];
        int []end = new int[50000];
        Map<Integer,Integer> ax = new HashMap<>();
        int max=0;
        for(int i=0;i<nums.length;i++){
            int k = nums[i];
            if(!a[k]){
                start[k] = i;
                a[k]=true;
            }else{
                end[k]=i;
            }
            int c= ax.getOrDefault(k,0)+1;
            max = Math.max(max,c);
            ax.put(k,c);
        }
        int minlen = 60000;
        //遍历ax
        Iterator<Map.Entry<Integer,Integer>> iterator = ax.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer,Integer> e = iterator.next();
            int key = e.getKey();
            int value = e.getValue();
            if(value==max){
                minlen = Math.min(minlen,end[key]-start[key]+1);
            }
        }
        return minlen;
    }
    @Test
    public void t(){
        findShortestSubArray( new int[]{1,2,2,3,1});
    }

}
