package 动态规划;

import java.util.Scanner;

/**
 * @Author hujf
 * @Date 2022/8/4 16:05
 * @Description TODO
 */
public class 最短路径 {

    public static void main(String[] args) {
        int[][] num = new int[4][4];
        num[0][1] = 2;
        num[0][2] = 3;
        num[1][3] = 4;
        num[2][3] = 1;
        shout(num);
    }

    private  static void shout(int[][] num) {
        int []path = new int[4];
        path[0] = 0;
        for(int i=1;i<path.length;i++){
            path[i] =Integer.MAX_VALUE;
        }


        for(int i=0;i<num.length;i++){
            for(int j=0;j<num[0].length;j++){
                if(num[i][j]!=0){
                    path[j] = Math.min(path[j],path[i]+num[i][j]);
                }
            }
        }
        System.out.println(path[1]+" "+path[2]+" "+path[3]);
        return ;

    }
}
