package leecode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hujf
 * @title: le518
 * @date 2020/11/20 0020上午 10:23
 * @description: TODO
 */
public class le518 {
    public int change2(int amount, int[] coins) {
        int len = coins.length;
        int []dp =new int[len];
        Map m = new HashMap();
        for(int i=0;i<coins.length;i++){
            m.put(coins[i],0);
        }
        dp[0]=0;
        if(m.containsKey(1)){
            dp[1] =1;
        }else{
            dp[1] =0;
        }

        for(int i=2;i<amount;i++){
            //如果包含，则
            int start =1;
            int end = i-1;

            while(start<=end){
                dp[i]+=dp[start]*dp[end];
            }



            if(m.containsKey(i)) {
                dp[i] =dp[i] +1;
            }
        }
        return 1;
    }


    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int x = coin; x < amount + 1; ++x) {
                dp[x] += dp[x - coin];
            }
        }
        return dp[amount];
    }

    @Test
    public void t(){
        change(5,new int[]{1, 2, 5});
    }
}
