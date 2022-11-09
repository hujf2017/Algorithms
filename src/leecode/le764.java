package leecode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author hujf
 * @Date 2022/11/9 10:49
 * @Description TODO
 */
public class le764 {


    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] a = new int[n][n];
        for (int i = 0; i < mines.length; i++) {
            a[mines[i][0]][mines[i][1]] = 1;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 0) {
                    max = Math.max(findNextLevel(i, j, a), max);
                }
            }
        }
        return max;
    }

    private int findNextLevel(int i, int j, int[][] a) {
        int count = 1;
        try {
            while (true) {
                if (a[i][j - count] == 0 & a[i - count][j] == 0 & a[i][j + count] == 0 && a[i + count][j] == 0) {
                    count++;
                } else {
                    return count;
                }
            }
        } catch (Exception e) {
            return count;
        }

    }

    @Test
    public void t() {
        orderOfLargestPlusSign2(1, new int[][]{{0, 0}});
    }

    public int orderOfLargestPlusSign2(int n, int[][] mines) {
        if(n*n == mines.length){
            return 0;
        }
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Math.min(Math.min(i , n - i-1), Math.min(j , n - j-1));
            }
        }
        //处理每个节点的行列
        for (int i = 0; i < mines.length; i++) {
            int x = mines[i][0];
            int y = mines[i][1];
            for (int j = 0; j < n; j++) {
                dp[x][j] = Math.min(dp[x][j], Math.abs(y - j)-1);
                dp[j][y] = Math.min(dp[j][y], Math.abs(x - j)-1);
            }
        }
        int bi = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bi = Math.max(bi, dp[i][j]);
            }
        }
        return bi+1;

    }
}
