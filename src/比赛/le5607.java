package 比赛;

import org.junit.Test;

/**
 * @author Hujf
 * @title: le5607
 * @date 2020/11/22 0022上午 11:00
 * @description: TODO
 */
public class le5607 {
    public int waysToMakeFair1(int[] nums) {
        int len = nums.length;
        int count =0;
        for(int i=0;i<len;i++){
            int ji =0;
            int odd = 0;
            for(int j=0;j<i;j++){
                if(j%2==0){
                    odd+=nums[j];
                }else{
                    ji+=nums[j];
                }
            }
            for(int j=i+1;j<len;j++){
                if(j%2==0){
                    ji+=nums[j];
                }else{
                    odd+=nums[j];
                }
            }

            if(ji==odd){
                count ++;
            }
        }
        System.out.println(count);
        return count;
    }


    public int waysToMakeFair(int[] nums) {
        int []dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        for(int i=2;i<nums.length;i++){
            dp[i] =nums[i]+dp[i-2];
        }
        int count =0;

        for(int i=0;i<nums.length;i++){
            int ji=0;
            int odd =0;
            if(i%2==0) {
                if (i - 1 >= 0) {
                    ji += dp[i - 1];
                }
                if (i - 2 >= 0) {
                    odd = dp[i - 2];
                }
            }else{
                if (i - 1 >= 0) {
                    odd += dp[i - 1];
                }
                if (i - 2 >= 0) {
                    ji = dp[i - 2];
                }
            }
            if(nums.length%2==0) {
                if ((nums.length - 1 - i) % 2 == 0) {
                    odd = dp[nums.length - 1] - dp[i]+odd;
                    ji = dp[nums.length - 2] - dp[i + 1] + nums[i + 1]+ji;
                } else {
                    odd += dp[nums.length - 1] - dp[i + 1] + nums[i + 1];
                    ji += dp[nums.length - 2] - dp[i];
                }
            }else{

            }

            if (odd ==ji){
                count ++;
            }
        }
        return count;
    }

    @Test
    public  void t(){
        waysToMakeFair(new int[]{2,1,6,4});
    }
}
