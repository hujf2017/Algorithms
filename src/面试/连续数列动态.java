package 面试;

import org.junit.Test;

/**
 * @author Hujf
 * @title: 连续数列动态
 * @date 2020/12/25 0025上午 9:52
 * @description: TODO
 */
public class 连续数列动态 {

    public int maxSubArray(int[] nums) {
        int sum =0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            max = Math.max(sum,max);
            if(sum<0){
                sum=0;
            }
        }
        return max;

    }

    @Test
    public void t(){
        maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    }
}
