package leecode;

/**
 * @author Hujf
 * @title: le122
 * @date 2020/11/8 0008上午 9:38
 * @description: TODO
 */
public class le122贪心思想 {
    public int maxProfit(int[] prices) {
        int i=0;
        int last  = prices[0];
        for(int k:prices){
            if(k>last){
                i+=k-last;
            }
            last = k;
        }
        return i;
    }
}
