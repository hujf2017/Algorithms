package leecode;

import org.junit.Test;

/**
 * @author Hujf
 * @title: lee121
 * @date 2020/11/8 0008上午 9:57
 * @description: TODO
 */
public class le121 {

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        int aim =0;
        for(int i:prices){
            if(i<min){
                min = i;
                max=0;
            }else if(i>max){
                max = i;
                if(aim<max-min) {
                    aim = max - min;
                }
            }
        }
        return aim;
    }

    @Test
    public  void t(){
        maxProfit (new int[]{2,1,2,1,0,1,2});
    }
}
