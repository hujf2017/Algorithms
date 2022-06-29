package leecode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author hujf
 * @Date 2022/6/29 16:03
 * @Description 岛屿
 */
public class le200 {
    int count = 0;
    int []k = new int[90001];
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] num = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    int aim = getfollow(num, i, j);
                    if (aim == 0) {
                        count++;
                    }
                    num[i][j] = aim==0?count:aim;
                }

            }
        }

        for(int i=1;i<=count;i++){
            int i1 = find(i);
            set.add(i1==0?i:i1);
        }
        return set.size();
    }
    Set set = new HashSet<>();
    private int getfollow(int[][] follow, int i, int j) {
        int c1 = 0;
        int c2 = 0;
        if (i - 1 >= 0) {
            if (follow[i - 1][j] > 0) {
                c1 = follow[i - 1][j];
            }
        }
        if (j - 1 >= 0) {
            if (follow[i][j - 1] > 0) {
                c2 = follow[i][j - 1];
            }
        }

        if(c1>0&&c2>0&&c1!=c2){
            int num1 = find(c1);
            k[c1] = num1==0?c1:num1;

            int num2 = find(c2);
            k[num2==0?c2:num2] =num1==0?c1:num1;
        }

        return c1>0&&c2>0?Math.max(c1, c2):c1+c2;

    }

    private int find(int c) {
        while(k[c]!=c){
            c = k[c];
        }
        return c;
    }

    @Test
    public void t() {
        char[][] x = new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}}
                ;

        numIslands(x);
    }
}
