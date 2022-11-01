package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/11/1 9:48
 * @Description TODO
 */
public class le695 {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    int k = 1;
                    k+=findNext(grid, i, j);
                    k += findDown(grid, i, j);
                    max = Math.max(k, max);
                }
            }
        }
        return max;
    }

    private int findDown(int[][] grid, int i, int j) {
        int num = 0;
        if (i + 1 < grid.length && grid[i + 1][j] == 1) {
            grid[i + 1][j] = 0;
            num++;
            num = num+dfs(grid, i + 1, j);
        }
        return num;
    }

    private int findNext(int[][] grid, int i, int j) {
        int num = 0;
        if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
            grid[i][j + 1] = 0;
            num++;
            num = num+dfs(grid, i, j + 1);
        }
        return num;
    }

    private int findLeft(int[][] grid, int i, int j) {
        int num = 0;
        if (j - 1 >= 0 && grid[i][j - 1] == 1) {
            grid[i][j - 1] = 0;
            num++;
            num =num+ dfs(grid, i, j - 1);
        }
        return num;
    }

    private int findUp(int[][] grid, int i, int j) {
        int num = 0;
        if (i - 1 >= 0 && grid[i - 1][j] == 1) {
            grid[i-1][j ] = 0;
            num++;
            num = num+dfs(grid, i - 1, j);
        }
        return num;
    }

    /**
     * @param grid
     * @param i
     * @param j
     * @return 0
     * 2      3
     * 1
     */
    private int dfs(int[][] grid, int i, int j) {
        int count = 0;
        count += findDown(grid, i, j);
        count += findNext(grid, i, j);
        count += findUp(grid, i, j);
        count += findLeft(grid, i, j);
        return count;
    }


    @Test
    public void t() {
        maxAreaOfIsland(new int[][]{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}}
        );
    }
}
