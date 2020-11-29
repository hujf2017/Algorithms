package 比赛;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author Hujf
 * @title: le5615
 * @date 2020/11/29 0029上午 11:55
 * @description: TODO
 */
public class le5615 {
    public int minMoves(int[] nums, int limit) {
        Set<Integer> a = new HashSet<>();
        int k = limit*2;
        Map<Integer,Integer> m = new HashMap();
        for(int i=0;i< nums.length/2;i++){
            a.add(nums[i]+nums[nums.length-1-i]);
            m.put(nums[i]+nums[nums.length-1-i],m.getOrDefault(nums[i]+nums[nums.length-1-i],0)+1);
        }
         int max =0;
        int aim = 0;
        for(int s :a){
            if(m.get(s)>max){
                aim=s;
                max = m.get(s);
            }
        }
        int count=0;
        for(int i=0;i< nums.length/2;i++){
            if(nums[i]+nums[nums.length-1-i]<aim){
                if(aim-nums[i]>limit){
                    count+=2;
                }else{
                    count++;
                }
            }
        }
        return count;
    }

    @Test
    public void t(){
        minMoves(new int[]{1,2,4,3},4);

    }}
