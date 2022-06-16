package leecode;

import org.junit.Test;

import java.util.*;

/**
 * @Author hujf
 * @Date 2022/6/15 16:42
 * @Description 用一个堆排序
 */
public class le719 {

    public int smallestDistancePair(int[] nums, int k) {
        int[] numx = new int[1000001];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int num = Math.abs(nums[i] - nums[j]);
                numx[num]++;
            }
        }
        for (int i = 0; i < numx.length; i++) {
            k = k - numx[i];
            if (k <= 0) {
                return i;
            }
        }
        return 0;
    }


    public int smallestDistancePair2(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        int left = 0, right = nums[len - 1] - nums[0];
        while (left <= right) {
            int mid = (right + left) / 2;
            //mid 在数组中的位置
            int count = 0;
            for (int i = 0; i < len; i++) {
                int x = binarySearch(nums, i, mid);
                count += x;
            }
            if (count >= k) {
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private int binarySearch(int[] nums, int index, int target) {
        int left = 0, right = index;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[index]-target < nums[mid]) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return index-left;
    }

    @Test
    public void tes(){
        smallestDistancePair2(new int[]{1,6,1},3);
    }
}
