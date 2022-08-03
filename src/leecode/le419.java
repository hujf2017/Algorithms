package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/8/3 9:44
 * @Description TODO
 */
public class le419 {
    public int countBattleships(char[][] board) {
        int count =0;
        for(int i=0;i<board.length;i++){
           for(int j=0;j<board[0].length;j++){
               if(board[i][j]=='X'){
                   count++;
                   board[i][j]='.';
                   fill(board,i,j);
                   fill2(board,i,j);

               }
           }
        }
        return count;
    }

    private void fill2(char[][] board, int i, int j) {
        while(j+1<board[0].length){
            if(panduan2(board,i,j)){
                board[i][j+1]='.';
                j++;
            }else {
                break;
            }
        }
    }

    private void fill(char[][] board, int i, int j) {
        while(i+1<board.length){
            if(panduan(board,i,j)){
                board[i+1][j]='.';
                i++;
            }else {
                break;
            }
        }
    }

    private boolean panduan(char[][] board, int i, int j) {
       return board[i+1][j]=='X';
    }

    private boolean panduan2(char[][] board, int i, int j) {
        return board[i][j+1]=='X';
    }

    @Test
    public void t(){
      //  char[][] board = {{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}};
        char[][] board = {{'X','X','X'}};
        System.out.println(countBattleships(board));

    }
}
