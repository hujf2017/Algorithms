package 剑指offer;

import org.junit.Test;

/**
 * @author Hujf
 * @title: of42
 * @date 2020/9/16 0016下午 12:15
 * @description: TODO
 */
public class of42 {
    static int nums[] = new int[]{1,3,5,3,-1,2,-2,4} ;
    @Test
    public void maxSubArray() {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (sum <= 0) {
                sum = num;
            } else {
                sum += num;
            }
            max = Math.max(max, sum);
        }
        System.out.println(max) ;
    }
}
