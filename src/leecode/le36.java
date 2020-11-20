package leecode;

/**
 * @author Hujf
 * @title: le36
 * @date 2020/11/20 0020上午 9:42
 * @description: TODO
 */
public class le36 {
    public boolean isValidSudoku(char[][] board) {
        int len = board.length;
        for(int i=0;i<len;i++){
            int mark[] =new int[len];
            for(int j=0;j<len;j++){
                if(board[i][j]!=0){
                    mark[j]=board[i][j];
                }
            }
        }
        return false;
    }
}
