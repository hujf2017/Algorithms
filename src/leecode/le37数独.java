package leecode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hujf
 * @title: le37数独
 * @date 2020/9/15 0015上午 9:02
 * @description: TODO
 */
public class le37数独 {

    private boolean[][] line = new boolean[9][9];
    private boolean[][] column = new boolean[9][9];
    private boolean[][][] block = new boolean[3][3][9];
    private boolean valid = false;
    private List<int[]> spaces = new ArrayList<int[]>();

    private char[][] board = {{'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
    @Test
    public  void solveSudoku() {
        //遍历
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                //如果是个点
                if (board[i][j] == '.') {
                    spaces.add(new int[]{i, j});
                } else {
                    int digit = board[i][j] - '0' - 1;
                    line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                }
            }
        }

        dfs(board, 0);
        System.out.println(board);
    }

    private  char[][] dfs(char[][] board, int pos) {
        if (pos == spaces.size()) {
            valid = true;
            return board;
        }

        int[] space = spaces.get(pos);
        int i = space[0], j = space[1];

        for (int digit = 0; digit < 9 && !valid; digit++) {
            if (!line[i][digit] && !column[j][digit] && !block[i / 3][j / 3][digit]) {
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                board[i][j] = (char) (digit + '0' + 1);
                dfs(board, pos + 1);
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = false;
            }
        }
        return board;
    }

}
