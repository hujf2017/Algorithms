package 剑指offer;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Hujf
 * @title: of59
 * @date 2020/11/20 0020下午 5:34
 * @description: TODO
 */
public class of59 {
    //优先级队列
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if(nums==null||k<=0){
            return new int[]{};
        }

        //最终结果数组
        int []res = new int[nums.length-k+1];
        //采用优先级队列
        PriorityQueue queue = new PriorityQueue(res.length,(o1,o2)-> {
                return (int)o2-(int)o1;
        });
        int numss[][] = new int[][]{};
        Arrays.sort(numss,(o1,o2)->{
                return o1[0] - o2[1];
        });

        PriorityQueue queue2 = new PriorityQueue(res.length, (o1,o2)->{
           return (int)o2-(int)o1;
        });

        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            queue2.offer(nums[i]);
        }

        return res;
    }

    @Test
    public void t(){
        maxSlidingWindow1(new int[]{0,1,2,3,4,5,6,7,8,9},2);
    }
}
