package leecode;

/**
 * @Author hujf
 * @Date 2022/10/11 17:36
 * @Description TODO
 */
public class le2428 {
    public int maxSum(int[][] grid) {
        int start = 1;
        int m = grid.length-1;
        int n = grid[0].length-1;
        int max =0;
        for(int i=start;i<m;i++){
            for(int j=start;j<n;j++){
                int sum =getSum(grid,i,j);
                if(sum>max){
                    max =sum;
                }
            }
        }
        return max;
    }

    private int getSum(int[][] grid, int i, int j) {
        return grid[i][j]+grid[i-1][j]+grid[i+1][j]+grid[i-1][j-1]+grid[i-1][j+1]+grid[i+1][j-1]+grid[i+1][j+1];
    }
}
