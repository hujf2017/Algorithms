package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/10/20 9:54
 * @Description m=0
 */
public class le474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int [][][]dp = new int[strs.length+1][m+1][n+1];
        for(int i=1;i<=strs.length;i++){
            for(int j=0;j<=m;j++){
                for(int k=0;k<=n;k++){
                    int one =getOne(strs[i-1]);
                    int zer0 = strs[i-1].length() - one;
                    dp[i][j][k]= dp[i-1][j][k];
                    //桶够用的情况下
                    if(one<=k&&zer0<=j){
                        dp[i][j][k] = Math.max( dp[i-1][j][k],dp[i-1][j-zer0][k-one]+1);
                    }
                }
            }
        }

        return dp[strs.length][m][n];
    }

    private int getOne(String str) {
        int count =0;
        for(int i=0;i<str.length();i++){
            char x = str.charAt(i);
            if(x=='1'){
                count++;
            }
        }
        return count;
    }


    @Test
    public void t(){
        findMaxForm(new String[]{"10", "0001", "111001", "1", "0"},5,3);
    }




    public void zeroonre(){
        //求不超过x的 最多的数
        int[] strs = {1, 3, 7, 2, 1};
        int x = 9;
        //最大容量
        int [][]dp = new int[strs.length+1][x+1] ;

        for(int i=1;i<=strs.length;i++){
            for(int j=1;j<=x;j++){
                //当新增的物品大于当前背包容量 取上一次
                if(strs[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-strs[i-1]]+1);

                }
            }
        }

        System.out.println(1);
    }
}
