package 比赛;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Hujf
 * @title: le5602
 * @date 2020/11/15 0015上午 11:31
 * @description: TODO
 */
public class le5602 {

    public int minOperations(int[] nums, int x) {
        int start = 0;
        int end = nums.length-1;
        Set<Integer> set = new HashSet();

        while(start <end){
            Set<Integer> settmp = new HashSet();
            for(int a:set){
                if(a-nums[start]>0) {
                    settmp.add(a-nums[start]);
                }else if(a-nums[start]==0){
                        return start;
                }
                if(a-nums[end]>0) {
                    settmp.add(a-nums[end]);
                }else if(a-nums[end]==0){
                    return start;
                }
                set = settmp;
            }
            start ++;
            end --;
        }
        return -1;
    }

    @Test
    public void t(){
        minOperations(new int[]{5,6,7,8,9},4);
    }
}
