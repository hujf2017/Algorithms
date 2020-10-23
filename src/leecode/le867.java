package leecode;

/**
 * @author Hujf
 * @title: le867
 * @date 2020/9/23 0023下午 3:58
 * @description: TODO
 */
public class le867 {
    public static void main(String args[]){
        int[][] A = {{1,2,3},{4,5,6}};
        A =transpose(A);
        System.out.println();
    }

    public static int[][] transpose(int[][] A) {
        int len1 = A.length;
        int ba[] = A[0];
        int len2 = ba.length;
        int b[][] = new int[len2][len1];
        for(int i=0;i<len2;i++){
            for(int j=0;j<len1;j++){
                b[i][j] = A[j][i];
            }
        }
        return b;
    }
}
