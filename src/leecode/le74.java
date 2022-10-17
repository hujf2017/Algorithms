package leecode;

/**
 * @Author hujf
 * @Date 2022/10/12 17:27
 * @Description TODO
 */
public class le74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i=0;
        if(matrix[0][0]>target) {
            return false;
        }
        int last = 0;
        for(;i<matrix.length;i++){
            if(matrix[i][0]>target){
                last = i-1;
                break;
            }else if(matrix[i][0]==target){
                return true;
            }else {
                last = i;
            }
        }

        for(int j=0;j<matrix[0].length;j++){
            if(matrix[last][j]==target){
                return true;
            }
        }
        return false;

    }
}
