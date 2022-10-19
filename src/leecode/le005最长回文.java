package leecode;

import org.junit.Test;

/**
 * @author Hujf
 * @title: le005最长回文
 * @date 2020/10/27 0027下午 3:57
 * @description: TODO
 */
public class le005最长回文 {
    public static String xs;
    public static int max = 0;
    public static boolean shodback = false;
    public static int startx;
    public static int endx;
    public static boolean isbig = false;

    public String longestPalindrome2(String s) {
        xs = s;
        for (int i = 0; i < s.length(); i++) {
            shodback = false;
            isbig = false;
            calca(i, s.length() - 1, 0);
        }
        return s.substring(startx, endx);
    }

    private void calca(int start, int end, int len) {
        if (shodback) {
            return;
        }
        if (isbig) {
            return;
        }
        if (xs.charAt(start) == xs.charAt(end)) {
            if (start == end) {
                if (max < len + 1) {
                    max = len + 1;
                    isbig = true;
                }
            } else if (start + 1 == end) {
                if (max < len + 2) {
                    max = len + 2;
                    isbig = true;
                }
            } else {
                calca(start + 1, end - 1, len + 2);
            }
        } else {
            calca(start, end - 1, 0);
        }
    }

    @Test
    public void t() {
        longestPalindrome("accca");
    }

    private void longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            for (int j = i + 1; j < n; j++) {
                if (dp[i][j]) {
                    continue;
                }
                dp[i][j] = dfs(dp, s, i, j);
                if (dp[i][j]) {
                    max = Math.max(j - i + 1, max);
                }
            }
        }
        System.out.println(max);
    }

    private boolean dfs(boolean[][] dp, String s, int left, int right) {
        if (left == right) {
            dp[left][right] = true;
            return true;
        } else if (left + 1 == right) {
            dp[left][right] = s.charAt(left) == s.charAt(right);
            return dp[left][right];
        } else {
            return (s.charAt(left) == s.charAt(right))&&dfs(dp, s, left + 1, right - 1);
        }
    }


    public String longestPalindrome3(String s) {
        char[] chars = s.toCharArray();
        if (chars.length < 2) {
            return s;
        }
        String max = String.valueOf(chars[0]);
        //先处理奇数的
        for (int i = 1; i < chars.length; i++) {
            StringBuilder aim = new StringBuilder();
            aim.append(chars[i]);
            aim = bfs(aim, chars, i, 1);
            if (max.length() < aim.length()) {
                max = aim.toString();
            }


            StringBuilder aim2 = new StringBuilder();
            aim2 = bfs2(aim2, chars, i, 0);
            if (max.length() < aim2.length()) {
                max = aim2.toString();
            }
        }
        return max;
    }

    private StringBuilder bfs2(StringBuilder num, char[] chars, int i, int index) {
        if (i - index > 0 && i + index < chars.length && chars[i - 1 - index] == chars[i + index]) {
            num.insert(0, chars[i - 1 - index]);
            num.append(chars[i + index]);
            bfs2(num, chars, i, ++index);
        }
        return num;
    }

    private StringBuilder bfs(StringBuilder num, char[] chars, int i, int index) {
        if (i - index >= 0 && i + index < chars.length && chars[i - index] == chars[i + index]) {
            num.insert(0, chars[i - index]);
            num.append(chars[i + index]);
            bfs(num, chars, i, ++index);
        }
        return num;
    }

}
