package leecode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author hujf
 * @Date 2022/10/17 9:33
 * @Description TODO
 */
public class le904 {
    public int totalFruit(int[] fruits) {
        if(fruits.length==1){
            return 1;
        }
        int[] dp = new int[fruits.length];
        int last = 0;
        int last2 = 0;
        dp[0] = 1;
        int dif = 0;
        int max = 0;
        for (int i = 1; i < fruits.length; i++) {
            if (fruits[last] == fruits[i]||fruits[last2]==fruits[i]) {
                if(fruits[last] == fruits[i]){
                    last = i;
                }
                if(fruits[last2]==fruits[i]){
                    last2 = i;
                }
                dp[i] = dp[i-1]+1;
            } else {
                //当只有一个时
                if(dif==0) {
                    dif++;
                    dp[i] = dp[i-1]+1;
                    last2 = i;
                }else {
                    dif = 1;
                    dp[i] = Math.abs(last2 - last)+1;
                    last = Math.max(last2,last);
                    last2 = i;
                }
            }
            max = Math.max(max,dp[i]);
        }

        return max;
    }

    @Test
    public void t() {
        totalFruit(new int[]{0});
    }
}
