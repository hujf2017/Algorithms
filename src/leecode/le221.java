package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/6/23 10:22
 * @Description 最大正方形
 */
public class le221 {
    int max = 0;
    char[][] matrix;
    boolean[][] booleans;
    public int maximalSquare(char[][] matrix) {
        this.matrix = matrix;
        booleans = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(booleans[i][j]){
                    continue;
                }
                getmax(i, j, 1);
            }
        }

        return max * max;
    }

    private void getmax(int i, int j, int len) {
        for (int x = i; x < i + len; x++) {
            if (x >= matrix.length) {
                return ;
            }
            for (int y = j; y < j + len; y++) {
                if (y >= matrix[0].length) {
                    return ;
                }
                if (matrix[x][y] == '0') {
                    booleans[x][y]=true;
                    setBoolean(x,y,max);
                    return;
                }
            }
        }
        if (max < len) {
            max = len;
        }
        getmax(i, j, len + 1);
    }

    private void setBoolean(int x, int y, int max) {
        for(int i=x-max+1;i<x+max-1;i++){
            for(int j=y-max+1;i<y+max-1;y++){
                if(i<matrix.length&&j<matrix[0].length) {
                    booleans[i][j] = true;
                }
            }
        }
    }


    @Test
    public void te() {
        char[][] ints = {{'1'}};

        maximalSquare(ints);
    }
}
