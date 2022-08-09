package leecode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author hujf
 * @Date 2022/8/9 9:30
 * @Description TODO
 */
public class le289 {
    private int[][] boards;

    public void gameOfLife(int[][] board) {
        // 创建复制数组 copyBoard
        boards= new int[board.length][board[0].length];

        // 从原数组复制一份到 copyBoard 中
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                boards[row][col] = board[row][col];
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (calc(i, j)) {
                    board[i][j] = 1;
                }else {
                    board[i][j] = 0;
                }

            }
        }
    }

    private boolean calc(int i, int j) {
        int count = 0;

        if (calc2(i - 1, j)) {
            count++;
        }
        if (calc2(i, j - 1)) {
            count++;
        }
        if (calc2(i + 1, j)) {
            count++;
        }
        if (calc2(i, j + 1)) {
            count++;
        }
        if (calc2(i + 1, j + 1)) {
            count++;
        }
        if (calc2(i + 1, j - 1)) {
            count++;
        }
        if (calc2(i - 1, j + 1)) {
            count++;
        }
        if (calc2(i - 1, j - 1)) {
            count++;
        }

        if (count < 2 ||count > 3) {
            return false;
        } else {
            if(boards[i][j]==1||count==3){
                return true;
            }else {
                return false;
            }
        }
    }

    private boolean calc2(int i, int j) {
        try {
            if (boards[i][j] == 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Test
    public void t(){
        gameOfLife(new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}});
    }
}
