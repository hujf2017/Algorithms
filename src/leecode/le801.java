package leecode;

/**
 * @Author hujf
 * @Date 2022/10/10 11:04
 * @Description 状态机  0 表示当前位置不交换 数量  1 表示当前位置需要交换
 *
 * 当前位置换不换
 * 1. 数组是递增  0位置 还是之前的  1位置 需要交换了 +1
 * 2。 如果是交叉的
 *
 */
public class le801 {
    public int minSwap(int[] nums1, int[] nums2) {
        int len = nums1.length;
        int [][]dp= new int[len][2];
        for (int i = 1; i < len; i++) {
            dp[i][0] = dp[i][1] = len + 10;
        }
        //交换或者不交换
        dp[0][0] =0;
        dp[0][1]=1;

        for(int i=1;i<len;i++){
            //如果不是递增 需要交换
            if(nums1[i]>nums1[i-1]&&nums2[i]>nums2[i-1]){
                dp[i][0] = dp[i-1][0];
                dp[i][1] = dp[i-1][1]+1;
            }

            //如果是交叉  其中一个需要交换
            if(nums1[i]>nums2[i-1]&&nums2[i]>nums1[i-1]){
                dp[i][0] = Math.min(dp[i][0],dp[i-1][1]);
                dp[i][1] = Math.min(dp[i][1],dp[i-1][0]+1);
            }

        }

        return Math.min(dp[len-1][0],dp[len-1][1]);
    }
}
