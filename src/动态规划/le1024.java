package 动态规划;

import java.util.Arrays;

/**
 * @author Hujf
 * @title: le1024
 * @date 2020/10/24 0024上午 9:17
 * @description: TODO
 */
public class le1024 {
    public int videoStitching(int[][] clips, int T) {
        int dp[] = new int[T+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i<T;i++){
            for(int[] clip:clips){
                if(clip[0]<i&&i<=clip[1]){
                    dp[i]=Math.min(dp[i],dp[clip[0]]+1);
                }
            }
        }
        return dp[T] == Integer.MAX_VALUE  ? -1 : dp[T];
    }
}
