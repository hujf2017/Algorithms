package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/6/30 10:22
 * @Description TODO
 */
public class le79 {
    char[][] board;
    char[] chars;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.chars = word.toCharArray();
        int index = 0;
        boolean[][] isvisit= new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char x = board[i][j];
                if (x == chars[index]) {
                    isvisit[i][j] = true;
                    if (findsmbf(i, j, index + 1,isvisit)) {
                        return true;
                    }
                    isvisit[i][j] = false;
                }
            }
        }
        return false;
    }

    private boolean findsmbf(int x, int y, int index,boolean[][] isvisit) {
        if (index >= chars.length) {
            return true;
        }

        char xx = chars[index];

        if(x-1>=0&&!isvisit[x-1][y]){
            if(board[x-1][y]==xx){
                isvisit[x-1][y] = true;
                if(findsmbf(x-1,y,index+1,isvisit)){
                    return true;
                }
                isvisit[x-1][y] = false;
            }
        }

        if(x+1<board.length&&!isvisit[x+1][y]){
            if(board[x+1][y]==xx){
                isvisit[x+1][y] = true;
                if(findsmbf(x+1,y,index+1,isvisit)){
                    return true;
                }
                isvisit[x+1][y] = false;
            }
        }

        if(y-1>=0&&!isvisit[x][y-1]){
            if(board[x][y-1]==xx){
                isvisit[x][y-1] = true;
                if(findsmbf(x,y-1,index+1,isvisit)){
                    return true;
                }
                isvisit[x][y-1] = false;
            }
        }

        if(y+1<board[0].length&&!isvisit[x][y+1]){
            if(board[x][y+1]==xx){
                isvisit[x][y+1] = true;
                if(findsmbf(x,y+1,index+1,isvisit)){
                    return true;
                }
                isvisit[x][y+1] = false;
            }
        }

        return false;
    }


    @Test
    public void t(){
        exist(new char[][]{{'A','B'}},"AB");
    }
}
