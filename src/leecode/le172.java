package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/10/14 15:39
 * @Description TODO
 */
public class le172 {
    public int trailingZeroes(int n) {
        if (n == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int tmp = i;
            while(tmp%10==0){
                tmp = tmp/10;
                count++;
            }

            while (tmp % 5 == 0) {
                tmp = tmp/5;
                count++;
            }
        }
        return count;
    }

    @Test
    public void t(){
        trailingZeroes(151);
    }
}
