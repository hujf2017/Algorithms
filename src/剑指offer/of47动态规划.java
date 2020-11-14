package 剑指offer;

/**
 * @author Hujf
 * @title: of47动态规划
 * @date 2020/11/14 0014下午 3:28
 * @description: TODO
 */
public class of47动态规划 {
    public int maxValue(int[][] grid) {
        int dp[][] = new int[grid.length][grid[0].length];
        //初始化
        dp[0][0] = grid[0][0];
        for (int i=1;i<grid[0].length;i++){
            dp[0][i] = grid[0][i]+dp[0][i-1];
        }

        for (int i=1;i<grid.length;i++){
            dp[i][0] = grid[i][0]+dp[i-1][0];
        }
        for (int i=1;i<grid.length;i++){
            for(int j=1;j<grid[0].length;j++){
                dp[i][j] =Math.max(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}
