package leecode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hujf
 * @title: le54螺旋矩阵
 * @date 2021/3/158:10
 * @description: 优先级排序  右>下>左>右
 * <p>
 * 1  2  3   4
 * 5  6  7   8
 * 9  10 11 12
 * 13 14 15 16
 */
public class le54螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List a = new ArrayList<>();
        if (matrix == null) {
            return a;
        }
        int width = matrix.length;//宽
        int len = matrix[0].length;//长
        int x = 0;
        int y = 0;
        boolean xadd = false;
        boolean yadd = true;
        boolean xdee = false;
        boolean ydee = false;
        while (a.size() < width * len) {
            a.add(matrix[x][y]);
            matrix[x][y] = 101;
            if (yadd) {
                if (y + 1 == len || matrix[x][y+1] == 101) {
                    xadd = true;
                    yadd = false;
                    x++;
                } else {
                    y++;
                }

            } else if (xadd) {
                if (x + 1 == width || matrix[x + 1][y] == 101) {
                    xadd = false;
                    ydee = true;
                    y--;
                } else {
                    x++;
                }
            } else if (ydee) {
                if (y == 0 || matrix[x][y - 1] == 101) {
                    ydee = false;
                    xdee = true;
                    x--;
                } else {
                    y--;
                }
            } else if (xdee) {
                if (x == 0 || matrix[x - 1][y] == 101) {
                    yadd = true;
                    xdee = false;
                    y++;
                } else {
                    x--;
                }
            }


        }

        return a;
    }

    @Test
    public void t() {
        spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}});
    }
}
