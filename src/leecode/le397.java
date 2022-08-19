package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/8/17 10:06
 * @Description TODO
 */
public class le397 {
    public int integerReplacement(int n) {
        if (n == 1) {
            return 0;
        }
        if (n % 2 == 0) {
            return 1 + integerReplacement(n / 2);
        }
        return 1 + Math.min(integerReplacement(n / 2), integerReplacement(n / 2 + 1));
    }

    @Test
    public void t() {
        integerReplacement(7);
    }
}
