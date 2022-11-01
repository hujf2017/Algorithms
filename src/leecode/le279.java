package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/10/19 17:55
 * @Description TODO
 */
public class le279 {
    public int numSquares(int n) {
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minn = Math.min(minn, f[i - j * j]);
            }
            f[i] = minn + 1;
        }
        return f[n];

    }
    @Test
    public void t(){
        numSquares(27);
    }
}
