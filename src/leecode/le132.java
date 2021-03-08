package leecode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Hujf
 * @title: le132
 * @date 2021/3/8 0008下午 2:08
 * @description: TODO
 */
public class le132 {
    boolean[][] f;
    int n;
    public int minCut(String s) {
        n = s.length();
        f = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], true);
        }

        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                //判断ij 是不是回文
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
            }
        }
        int []dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        //得到一个二维数组 f可以判断是不是回文ij
        for(int i=0;i<n;i++){
            if(f[0][i]){
                dp[i]=0;
            }else{
                for(int j=0;j<i;j++){
                    if(f[j+1][i]){
                        dp[i] = Math.min(dp[j]+1,dp[i]);
                    }
                }
            }
        }
        return dp[n-1];
    }
    @Test
    public void t(){
        minCut("cdd");
    }

}
