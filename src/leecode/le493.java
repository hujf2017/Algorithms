package leecode;

import org.junit.Test;

/**
 * @author Hujf
 * @title: le493
 * @date 2020/11/28 0028上午 9:21
 * @description: TODO
 */
public class le493 {

    public int reversePairs2(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > (long)2 * nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }


    public int reversePairs(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        return reversePairsRecursive(nums, 0, nums.length - 1);
    }

    private int reversePairsRecursive(int[] nums, int left, int right) {
        if (left == right) {
            return 0;
        } else {
            int mid = (right + left) / 2;
            int n1 = reversePairsRecursive(nums, left, mid);
            int n2 = reversePairsRecursive(nums, mid + 1, right);
            int reset = n1 + n2;
        }
        return 0;
    }



    @Test
    public void t() {
        reversePairs(new int[]{2147483647,2147483647,2147483647,2147483647,2147483647,2147483647});
    }
}
