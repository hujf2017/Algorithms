package leecode;

import org.junit.Test;

/**
 * @author Hujf
 * @title: le1252
 * @date 2020/9/15 0015上午 10:14
 * @description: TODO
 */
public class le1252 {

    @Test
    public int oddCells(int n, int m, int[][] indices) {
        int k[][] = new int[n][m];
        for(int i=0;i<indices.length;i++){
            int[] k2 = indices[i];
            for(int j=0;j<m;j++){
                k[k2[0]][j]+=1;
            }
            for(int j=0;j<n;j++){
                k[j][k2[1]]+=1;
            }
        }
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(k[i][j]%2==1){
                    count++;
                }
            }
        }
        return count;
    }
}
