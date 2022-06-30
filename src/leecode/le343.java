package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/6/30 9:48
 * @Description TODO
 */
public class le343 {

    public int integerBreak(int n) {
        return calc(n,(int)Math.sqrt(n),n/2+1);
    }

    private int calc(int n, int k1, int k2) {
        int max = 1;
        while (k1 < k2) {
            max = Math.max((int)(Math.pow(n / k1, k1-(n - n / k1 * k1)) * Math.pow(n / k1 + 1, n - n / k1 * k1)), max);
            k1++;
        }
        return max;
    }

    @Test
    public void t() {
        integerBreak(8);
    }
}
