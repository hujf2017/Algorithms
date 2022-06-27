package leecode;

/**
 * @Author hujf
 * @Date 2022/6/27 9:32
 * @Description TODO
 */
public class le6100 {
    static final int MOD = (int) 1e9 + 7;
    public int countHousePlacements(int n) {

        int []dp = new int[n+1];
        dp[0] = 1;
                dp[1]=2;
        long x =0;
        for(int i=2;i<=n;i++){
            dp[i] = (dp[i-1]+dp[i-2])%MOD;
        }
        return(int) ((long)dp[n]*dp[n])%MOD;
    }
}
