package leecode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author hujf
 * @Date 2022/11/28 10:40
 * @Description 思路   如果知道 任意 x个数  分 2组的 最大值
 *                     那么 就可用知道  x+1个数  分3组的最大值  从头遍历
 *                     知道 2个数分2组  加上剩余的
 *                        知道 3个数分2组  加上剩余的
 *                          知道 4个数分2组  加上剩余的  到x+1为止
 */
public class le813 {
    public double largestSumOfAverages(int[] nums, int k) {
        int len = nums.length;
        double[][] dp = new double[len + 1][k + 1];
        double[] sum = new double[len + 1];
        //前缀和
        for (int i = 0; i < len; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        //初始化 i个数 取1组的值
        for (int i = 1; i <= len; i++) {
            dp[i][1] = sum[i] / i;
        }


        //分组递增
        for (int i = 2; i <= k; i++) {
            //第x个数
            for (int j = i; j <= len; j++) {
                    //当前第2 n-1个数
                  for(int x = i-1;x<j;x++ ){
                      dp[j][i] = Math.max(dp[j][i],dp[x][i-1]+(sum[j]-sum[x])/(j-x));
                  }
            }
        }
        return dp[len][k];
    }


    //给定一个数组  求分割2个的最大平均值
    @Test
    public void t() {
        int[] arr = new int[]{1};
        largestSumOfAverages(arr,1);

//
//        double[][] dp = new double[arr.length + 1][4];
//
//        double[] sum = new double[arr.length + 1];
//        //前缀和
//        for (int i = 0; i < arr.length; i++) {
//            sum[i + 1] = sum[i] + arr[i];
//        }
//        //初始化 i个数组一组
//        for (int i = 1; i < dp.length; i++) {
//            dp[i][1] = sum[i] / i;
//        }
//
//        //切割2组  最大值  x个数 切 j-1个最大值   2个数 切2组  3个数切2组  4个数切2组的最大值
//
//        for (int k = 2; k <= 3; k++) {
//            //切的第一个地方
//            for (int i = k; i <= arr.length; i++) {
//                //切的第几个
//                for (int j = k - 1; j < i; j++) {
//                    dp[i][k] = Math.max(dp[i][k], dp[j][k - 1] + (sum[i] - sum[j]) / (i - j));
//                }
//            }
//        }
//        System.out.println(dp);


    }
}
