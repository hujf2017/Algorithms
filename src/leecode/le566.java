package leecode;

/**
 * @author Hujf
 * @title: le566
 * @date 2020/11/25 0025上午 10:17
 * @description: TODO
 */
public class le566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int len1 = nums.length;
        int len2 = nums[0].length;
        int []a = new int[len1*len2];
        if(r*c!=len1*len2){
            return nums;
        }
        int count =0;
        for(int i=0;i<len1;i++){
            for(int j=0;j<len2;j++){
                a[count++] = nums[i][j];
            }
        }
        count =0;
        int k[][]= new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                k[i][j] = a[count++];
            }
        }
        return k;
    }
}
