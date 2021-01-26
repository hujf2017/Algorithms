package leecode;

import java.util.Arrays;

/**
 * @author Hujf
 * @title: le1128
 * @date 2021/1/26 0026上午 8:17
 * @description: TODO
 */
public class le1128 {
    public int numEquivDominoPairs(int[][] dominoes) {
        int count =0;
        int []res = new int[100];
        for(int []d:dominoes){
            Arrays.sort(d);
            int index = d[0]*10+d[1];
            //位置定位
            res[index] +=1;
            count+=res[index];
        }
        return count;
    }
}
