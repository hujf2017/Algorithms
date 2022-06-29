package leecode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author hujf
 * @Date 2022/6/28 17:13
 * @Description 找又区间  处理结束
 */
public class le436 {
    public int[] findRightInterval(int[][] intervals) {
        Map<Integer,Integer> numstart = new HashMap<>(10000);
        Map<Integer,Integer> numindex = new HashMap<>(10000);
        int counts =0;
        for(int[]nums:intervals){
            numstart.put(nums[0],nums[1]);
            numindex.put(nums[0],counts++);
        }
        //处理结束
        int []statt = new int[intervals.length];
        int count =0;
        for(int[]nums:intervals){
            int end = nums[1];
            //找这个end后面的第一个 start
            int num = find(end,numstart,numindex);
            if(num>20000){
                statt[count++] = -1;
            }else{
                statt[count++] = num;
            }
        }
        return statt;
    }

    private int find(int end, Map<Integer,Integer> numstart, Map<Integer,Integer> numindex) {
        while(end<1e6+1){
            if(numstart.containsKey(end)){
                return numindex.get(end);
            }
            end++;
        }
        return end;
    }

    @Test
    public void t(){
        findRightInterval(new int[][]{{-41,-21},{-1,0}});
    }

}