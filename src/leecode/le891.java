package leecode;

import org.junit.Test;

import java.util.*;

/**
 * @Author hujf
 * @Date 2022/11/18 14:01
 * @Description TODO
 */
public class le891 {
    int len = 0;
    int[] nums;
    int mod = 1000000007;

    public int sumSubseqWidths(int[] nums) {
        len = nums.length;
        this.nums = nums;
        //排序
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            //以 i为最大
            for (int j = 0; j < i; j++) {
                if (i - j > 0) {
                    long nuxm = calc(i, j);
                    sum = sum % mod + nuxm ;
                }
            }
        }
        return (int) sum % mod;
    }

    private long calc(int i, int j) {
        return (long) (Math.pow(2, i-j-1) % mod * ((nums[i] - nums[j]) % mod))%mod;
    }

    long sum = 0;


    @Test
    public void t() {
        sumSubseqWidths(new int[]{1,2,3,4});
    }
}
