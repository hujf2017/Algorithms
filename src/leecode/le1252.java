package leecode;

import org.junit.Test;

/**
 * @author Hujf
 * @title: le1252
 * @date 2020/9/15 0015上午 10:14
 * @description: TODO
 */
public class le1252 {


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




    public int oddCells2(int n, int m, int[][] indices) {

        int []hen = new int[n];
        int []shu = new int[m];
        for(int i=0;i<indices.length;i++){
            hen[indices[i][0]]+=1;
            shu[indices[i][1]]+=1;
        }
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((hen[j]+shu[i])%2==1){
                    count++;
                }
            }
        }
        return count;
    }


    @Test
    public void t(){
        oddCells2(2,3,new int[][]{{0,1},{1,1}});
    }
}
