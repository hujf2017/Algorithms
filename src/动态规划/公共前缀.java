package 动态规划;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/10/12 14:02
 * @Description TODO
 */
public class 公共前缀 {
    public int deleteString(String s) {
        char[] chars = s.toCharArray();
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = s.length() - 1; j >= 0; j--) {
                if (chars[i] != chars[j]) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                }
            }
        }

        int []dps = new int[s.length() + 1];
        dps[s.length()] = 0;
        for(int i = s.length()-1; i >= 0; --i) {
            dps[i] =1;
            //j 表示前缀长度至少为1
            for(int j = 1; i + 2*j <= s.length(); ++j) {
                //当前缀长度大于=j时  即科加入
                if(dp[i][i + j] >= j) {
                    //判断删掉j长后 长度 和之前的比 取最大
                    dps[i] = Math.max(dps[i], 1 + dps[i + j]);
                }
            }
        }

        return dps[0];
    }


    @Test
    public void t(){

        deleteString("aaabaab");
    }
}
