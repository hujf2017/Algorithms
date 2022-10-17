package leecode;

import org.junit.Test;
import org.junit.experimental.max.MaxHistory;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author hujf
 * @Date 2022/10/13 11:33
 * @Description TODO
 */
public class le310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> list = new ArrayList<>();
        int[] numx = new int[n];
        int[][] nums = new int[n][n];
        for (int i = 0; i < edges.length; i++) {
            nums[edges[i][0]][edges[i][1]] = 1;
            nums[edges[i][1]][edges[i][0]] = 1;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            dfs(i, nums, 1, 0);
            numx[i] = le;
            le =0;
            min = Math.min(min, numx[i]);
        }
        for (int i = 0; i < numx.length; i++) {
            if (numx[i] == min) {
                list.add(i);
            }
        }
        return list;
    }
    int le =0;
    private void dfs(int node, int[][] nums, int level,int tmp) {
        le = Math.max(level,le);
        for (int i = 0; i < nums[0].length; i++) {
            if (nums[node][i] == 1) {
                nums[node][i] = 0;
                nums[i][node] = 0;
                dfs(i, nums, level + 1,tmp);
                nums[node][i] = 1;
                nums[i][node] = 1;
            }
        }
    }


    @Test
    public void t() {
        int[][] ass = {{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};
        findMinHeightTrees(6, ass);
    }
}
