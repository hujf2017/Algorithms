package leecode;

import org.junit.Test;

/**
 * @author Hujf
 * @title: le1004
 * @date 2021/2/19 0019上午 9:37
 * @description: TODO
 */
public class le1004{
    /**
     *
     * @param A
     * @param rsum 右侧0的个数
     * @return
     */
    public int longestOnes(int[] A, int K) {
        int left = 0, lsum = 0, rsum = 0;
        int ans = 0;
        for(int right=0;right<A.length;right++){
            rsum+=1-A[right];
            //找到相等的为止
            while(rsum-lsum>K){
                lsum += 1 - A[left];
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    @Test
    public void t(){
        longestOnes(new int[]{0,0,1,1,1},1);
    }
}