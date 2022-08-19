package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/8/18 16:20
 * @Description TODO
 */
public class le59 {
    public int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];
        int k = 0;
        int x = 0;
        int y = 0;

        int startx = 0;
        int endx = n - 1;

        int starty = 0;
        int endy = n - 1;
        int type = 1;
        while (k < n * n) {
            k++;
            if (k == 15) {
                int z = 0;
            }
            nums[x][y] = k;


            switch (type) {
                case 1:
                    if (x < endx && y == endy) {
                        startx++;
                        type = 2;
                        k--;
                        continue;
                    }
                    y++;
                    continue;
                case 2:
                    if (x == endx && y > starty) {
                        endy--;
                        type = 3;
                        k--;
                        continue;
                    }
                    x++;
                    continue;
                case 3:
                    if (x >startx&&y==starty) {
                        endx--;
                        type = 4;
                        k--;
                        continue;
                    }
                    y--;
                    continue;
                default:
                    if (x ==startx ) {
                        starty++;
                        type = 1;
                        k--;
                        continue;
                    }
                    x--;

            }
        }
        return nums;
    }

    @Test
    public void t() {
        generateMatrix(3);
    }
}
