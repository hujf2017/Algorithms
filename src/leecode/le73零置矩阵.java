package leecode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Hujf
 * @title: le73零置矩阵
 * @date 2021/3/2113:56
 * @description: TODO
 */
public class le73零置矩阵 {
    private int [][] ano;
    int len;
    int with;
    public void setZeroes(int[][] matrix) {
         len = matrix.length;
         with = matrix[0].length;
        ano = new int[len][with];
        HashSet<Integer> setlen = new HashSet();
        HashSet<Integer> setwith = new HashSet();
        for(int i=0;i<len;i++){
            for(int j =0;j<with;j++){
                int num = matrix[i][j];
                if(num == 0){
                    setlen.add(i);
                    setwith.add(j);
                }
            }
        }
//        for(int i=0;i<len;i++){
//            for(int j =0;j<with;j++){
//                if(setlen.contains(i)||setwith.contains(j)){
//                    matrix[i][j] =0;
//                }
//            }
//        }

        for(int num:setlen){
            int [] a = new int[with];
            Arrays.fill(a,0);
        }
    }


    @Test
    public void t(){
        setZeroes(new int[][]{{1,1,1},{1,0,1},{1,1,1}});
    }
}
