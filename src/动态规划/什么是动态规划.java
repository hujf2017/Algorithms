package 动态规划;

import org.junit.Test;

/**
 * @author Hujf
 * @title: 什么是动态规划
 * @date 2020/10/24 0024上午 9:19
 * @description: TODO
 */
public class 什么是动态规划 {
    //把一个大问题拆解成一堆  求从最上层到最下层的最大和。
    //7
    //3 8
    //8 1 0
    //2 7 4 4
    //4 5 2 6 5
    int sum = 0;

    public int maxSum(int a[][]){
        int k=5;
        int[][] dp= a;
        int [][]max = new int[6][6];
        for(int i=0;i<k;i++){
            max[k-1][i] = dp[k-1][i];
        }
        for(int i=k-1;i>=0;i--){
            for(int j=0;j<=i;j++){
                max[i][j] =Math.max(max[i+1][j],max[i+1][j+1])+dp[i][j];
            }
        }
        return max[0][0];
    }

    @Test
    public void test(){
        int as [][] = new int[][]{{7,0,0,0,0},{3,8,0,0,0}
        ,{8,1,0,0,0},{2,7,4,4,0},{4,5,2,6,5}};
        maxSum(as);
    }

}
