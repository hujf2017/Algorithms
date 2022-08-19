package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/8/15 15:53
 * @Description TODO
 */
public class le64 {
    int[][] grid;
    int min = Integer.MAX_VALUE;

    public int minPathSum(int[][] grid) {
        int dp[][] = new int[grid.length][grid[0].length];

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i==0&&j==0){
                    dp[i][j] = grid[0][0];
                }else {
                    int min1 = Integer.MAX_VALUE;
                    if(i>0){
                        min1 = Math.min(dp[i-1][j]+grid[i][j],min1);
                    }
                    if(j>0){
                        min1 = Math.min(dp[i][j-1]+grid[i][j],min1);
                    }
                    dp[i][j] = min1;
                }
            }
        }
        return dp[grid.length-1][grid[0].length-1];

















//        this.grid = grid;
//        dfs( 0, 0, 0);
//        return min;
    }

    private void dfs(int x, int y, int count) {
        if(x==grid.length-1&&y==grid[0].length-1){
            min = Math.min( count+grid[x][y],min);
        }
        if(y+1<grid[0].length) {
            dfs(x , y+ 1, count + grid[x][y]);
        }
        if(x+1<grid.length) {
            dfs(x + 1, y, count + grid[x][y]);
        }

    }

    @Test
    public void t(){
        int[][] ints = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        minPathSum(ints);
    }

}
