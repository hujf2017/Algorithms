package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/8/15 16:32
 * @Description TODO
 */
public class le130 {
    boolean[][] asd;
    char[][] board;
    public void solve(char[][] board) {
        this.board = board;
        asd = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            dfs(i, 0);
        }
        for (int i = 0; i < board.length; i++) {
            dfs(i, board[0].length-1);
        }
        for (int i = 0; i < board[0].length; i++) {
            dfs(0, i);
        }
        for (int i = 0; i < board[0].length; i++) {
            dfs(board.length-1, i);
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(asd[i][j]){
                    board[i][j]='O';
                }else {
                    board[i][j]='X';
                }
            }
        }
    }

    private void dfs(int x, int y) {
        if (asd[x][y]) {
            return;
        } else {
            if(board[x][y]=='O'){
                asd[x][y] = true;
                if (x - 1 > 0) {
                    dfs(x - 1, y);
                }
                if (y - 1 > 0) {
                    dfs(x, y - 1);
                }
                if (x + 1 < asd.length) {
                    dfs(x+1, y );
                }
                if (y + 1 < asd[0].length) {
                    dfs(x, y + 1);
                }
            }

        }
    }


    @Test
    public void t(){
        char[][] chars = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        solve(chars);
    }

}
