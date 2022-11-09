package leecode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author hujf
 * @Date 2022/11/3 16:01
 * @Description TODO
 */
public class le1668 {
    public int maxRepeating(String sequence, String word) {
        if (sequence.length() < word.length()) {
            return 0;
        }
        int[] dp = new int[sequence.length()];
        for (int i = word.length() - 1; i < sequence.length(); i++) {
            boolean ok = true;
            for (int j = 0; j < word.length(); j++) {
                if (sequence.charAt(i - word.length() + 1 + j) != word.charAt(j)) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                dp[i] = (i == word.length() - 1 ? 0 : dp[i - word.length()]) + 1;
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    @Test
    public void t() {

        maxRepeating("aaaaa", "aa");
    }
}
