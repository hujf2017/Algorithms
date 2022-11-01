package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/10/31 17:14
 * @Description 1超过2个 必须要 换一个
 */
public class le481 {
    public int magicalString(int n) {
        if (n == 1) {
            return 1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int dp[][] = new int[n][2];
        dp[0][0] = 1;
        dp[1][0] = 2;

        dp[0][1] = 2;
        dp[1][1] = 2;
        int index = 1;
        int index2 = 1;
        int count1 = 1;
        int count2 = 0;
        int num = 1;
        int num2 = 0;
        for (int i = 2; i < n; i++) {
            int k = dp[index][0];
            if (k == 1) {
                dp[i][0] = dp[i - 1][0] == 1 ? 2 : 1;
                num = 0;
                index++;
            } else {
                if (num == 1) {
                    dp[i][0] = dp[i - 1][0];
                    index++;
                    num = 0;
                } else {
                    dp[i][0] = dp[i - 1][0] == 1 ? 2 : 1;
                    num = 1;
                }
            }
            if (dp[i][0] == 1) {
                count1++;
            }

            int k2 = dp[index2][1];
            if (k2 == 1) {
                dp[i][1] = dp[i - 1][1] == 1 ? 2 : 1;
                num2 = 0;
                index2++;
            } else {
                if (num2 == 0) {
                    dp[i][1] = dp[i - 1][1] == 1 ? 2 : 1;
                    num2 = 1;
                } else {
                    dp[i][1] = dp[i - 1][1];
                    num2 = 0;
                    index2++;
                }
            }
            if (dp[i][1] == 1) {
                count2++;
            }
        }
        if (num==0) {
            return count1;
        } else {
            return count2;
        }
    }

    @Test
    public void t() {
        System.out.println(magicalString(8));
    }
}
