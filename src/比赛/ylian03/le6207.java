package 比赛.ylian03;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/10/17 9:18
 * @Description 7 1 3 5 6
 * 1 5
 */
public class le6207 {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int l = -1;
        int minLocal = -1;
        int maxLocal = -1;

        long res = 0;
        //
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxK || nums[i] < minK) {
                //维护一个最小数组
                l = i;
            }

            if (nums[i] == minK) {
                minLocal = i;

            }

            if (nums[i] == maxK) {
                maxLocal = i;
            }
            int num;
            if ( (num= Math.min(minLocal, maxLocal) - l) > 0) {
                res += num;
            }
        }

        return res;
    }

    @Test
    public void t() {
        countSubarrays(new int[]{1, 1, 1, 1, 1, 1}, 1, 1);

    }
}
