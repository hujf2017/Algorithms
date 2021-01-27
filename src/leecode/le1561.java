package leecode;

import java.util.Arrays;

/**
 * @author Hujf
 * @title: le1561
 * @date 2021/1/27 0027上午 9:13
 * @description: TODO
 */
public class le1561 {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int sum =0;
        int len = piles.length/3 ;
        int i=piles.length-2;
        while(len>0){
            sum+=piles[i];
            i-=2;
            len--;
        }
        return sum;
    }
}
