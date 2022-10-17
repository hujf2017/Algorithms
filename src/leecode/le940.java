package leecode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author hujf
 * @Date 2022/10/14 9:14
 * @Description 每个字符加入 需要一个dp
 */
public class le940 {
    public int distinctSubseqII(String s) {
        char[] chars = s.toCharArray();
        int[] dp = new int[s.length()];
        int[] last = new int[26];
        for (int i = 0; i < chars.length; i++) {
            //每加入一个  需要计算

            //1. 如果加入的这个之前没有

            //2. 如果加入的这个之前有

            //3. 加入的这个需要和每一个
            for (int j = 0; i < 26; j++) {
                if (last[j] != -1) {
                    dp[i] = dp[i] + dp[last[j]];
                }
            }

            last[chars[i] - 'a'] = i;

        }
        return 0;
    }

    public int distinctSubseqII1(String s) {
        final int MOD = 1000000007;
        int[] last = new int[26];
        Arrays.fill(last, -1);

        int n = s.length();
        int[] f = new int[n];
        Arrays.fill(f, 1);
        for (int i = 0; i < n; ++i) {

            for (int j = 0; j < 26; ++j) {
                //如果是一个之前存在的节点  那么只需要把之前存在的节点的值直接加进来
                if (last[j] != -1) {
                    f[i] = (f[i] + f[last[j]]) % MOD;
                }
            }
            last[s.charAt(i) - 'a'] = i;
        }

        int ans = 0;
        for (int i = 0; i < 26; ++i) {
            if (last[i] != -1) {
                ans = (ans + f[last[i]]) % MOD;
            }
        }
        return ans;
    }


    @Test
    public void t() {
        distinctSubseqII("aba");
    }
}
