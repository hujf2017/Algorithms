package leecode;

/**
 * @Author hujf
 * @Date 2022/8/15 17:58
 * @Description TODO
 */
public class le6148 {
    int[] num = new int[101];
    int n;
    public int[][] largestLocal(int[][] grid) {
        this.n = grid.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                num[grid[i][j]] = 1;
            }
        }

        int[][] xx = new int[n - 2][n - 2];
        for (int i = 0; i < xx.length; i++) {
            for (int j = 0; j < xx.length; j++) {
                xx[i][j] = Mathx(num);

                //吧地 j列的 全部去掉
                calc(num,i,j,grid);

            }
        }

        return null;

    }

    private void calc(int[] num, int x, int y,int [][]grid) {
        for(int i=0;i<n-1;i++){
            num[grid[x][i]] -=1;
        }
    }

    private int Mathx(int[] num) {
        for (int i = 100; i > 0; i--) {
            if (num[i] != 0) {
                return i;
            }
        }

        return 1;
    }
}
