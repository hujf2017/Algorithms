package leecode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Author hujf
 * @Date 2022/11/10 9:23
 * @Description TODO
 */
public class le864 {
    int[] keys = new int[26];
    char[][] arr;
    int keyTotal = 0;

    public int shortestPathAllKeys(String[] grid) {
        int len2 = grid[0].length();
        int len1 = grid.length;
        arr = new char[len1][len2];
        int startX = -1;
        int startY = -1;
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                arr[i][j] = grid[i].charAt(j);
                if (arr[i][j] >= 'a' && arr[i][j] <= 'z') {
                    keyTotal++;
                }
                if (arr[i][j] == '@') {
                    startX = i;
                    startY = j;
                }
            }
        }
        Arrays.fill(stepMin, Integer.MAX_VALUE);
        HashSet<Integer> thisWay = new HashSet();
        dfs(startX, startY, 0, 0, arr);

        return step==Integer.MAX_VALUE?-1:step;
    }

    private int step = Integer.MAX_VALUE;
    private int[] stepMin = new int[26];
    private void dfs(int startX, int startY, int key, int stepTmp, char[][] arr) {

        if (startX < 0 || startX >= arr.length) {
            return;
        }
        if (startY < 0 || startY >= arr[0].length) {
            return;
        }
        char rmp = arr[startX][startY];
        int num = rmp - 'a';
        if (rmp == '#') {
            return;
        } else if (rmp >= 'a' &&rmp <= 'z') {
            keys[num] = 1;
            stepMin[num] = Math.min(stepMin[num], stepTmp);
        } else if (rmp >= 'A' && rmp<= 'Z') {
            if (keys[rmp- 'A'] == 0) {
                return;
            }
        }

        arr[startX][startY] = '#';

        for (int i = 0; i < 4; i++) {
            switch (i) {
                case 0:
                    dfs(startX + 1, startY, key, stepTmp+1, arr);
                    break;
                case 1:
                    dfs(startX, startY + 1, key, stepTmp+1, arr);
                    break;
                case 2:
                    dfs(startX - 1, startY, key, stepTmp+1, arr);
                    break;
                default:
                    dfs(startX, startY - 1, key, stepTmp+1, arr);
            }
        }
        arr[startX][startY] = rmp;
    }

    @Test
    public void t() {
        System.out.println(shortestPathAllKeys(new String[]{"@....b","a####.","......"
}));
    }
}
