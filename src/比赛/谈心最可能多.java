package 比赛;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author hujf
 * @Date 2022/6/21 14:27
 * @Description TODO
 */
public class 谈心最可能多 {
    public int minRemainingSpace(int[] N, int V) {
        int[] dp = new int[N.length + 1];
        Arrays.sort(N);
        if (N[0] > V) {
            return V;
        }
        dp[0] = N[0];
        for (int i = 1; i < N.length; i++) {
            if (dp[i - 1] + N[i] <= V) {
                dp[i] = dp[i - 1] + N[i];
            } else {
                dp[i] = dp[i - 1] - N[i - 1] + N[i];
                if (dp[i] > V) {
                    return V - dp[i - 1];
                }
            }
        }
        return V - dp[N.length - 1];
    }


    @Test
    public void t() {
        minRemainingSpace2(new int[]{8, 19, 18, 23, 16, 20, 3}, 70);
    }


    public int minRemainingSpace2(int[] N, int V) {
        int[] dp = new int[2001];

        for (int i = 0; i < N.length; i++) {
            //针对当前值，计算
            for (int j = V; j >= N[i]; j--) {
                if (dp[j] < dp[j - N[i]] + N[i]) {
                    dp[j] = dp[j - N[i]] + N[i];
                }
            }

        }


        return dp[V];
    }
}
