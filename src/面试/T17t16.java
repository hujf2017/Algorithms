package 面试;

import org.junit.Test;

/**
 * @author Hujf
 * @title: T17t16
 * @date 2020/11/14 0014下午 2:20
 * @description: TODO
 */
public class T17t16 {
    public int massage(int[] nums) {

        int max =0;
        if(nums.length==0){
            return 0;
        }else if(nums.length==1){
            return nums[0];
        }else if(nums.length==2) {
            return Math.max(nums[0],nums[1]);
        }else {
            int []dp = new int[nums.length];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0],nums[1]);
            for (int i = 2; i < nums.length; i++) {
                dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
                if(max<dp[i]){
                    max = dp[i];
                }
            }
        }
        return max;
    }


    @Test
    public void t(){
        massage(new int[]{2,1,1,2});
    }
}
