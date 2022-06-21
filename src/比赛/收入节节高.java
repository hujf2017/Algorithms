package 比赛;

/**
 * @Author hujf
 * @Date 2022/6/21 14:53
 * @Description TODO
 */
public class 收入节节高 {

    public int findMaxCI(int[] nums) {
        int []dp = new int[nums.length];
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return 1;
        }
        dp[0]=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                dp[i]=dp[i-1]+1;
            }else{
                dp[i]=1;
            }
        }
        int max =0;
        for(int k:dp){
            if(max<k){
                max = k;
            }
        }
        return max;
    }
}
