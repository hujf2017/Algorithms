package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/8/29 18:28
 * @Description TODO
 */
public class le319 {
    public int bulbSwitch(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int k = (int) Math.pow(i, 0.5);
            if (k * k == i) {
                count++;
            }
        }
        return count;
    }

    @Test
    public void t(){
        bulbSwitch(4);
    }
}
