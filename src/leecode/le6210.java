package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/10/17 14:00
 * @Description TODO
 */
public class le6210 {
    public int minimizeArrayValue(int[] nums) {
        long num = 0;
        long tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            num += nums[i];
            tmp = Math.max(tmp, num / (i + 1) + 1);
        }
        return (int) tmp;
    }


    public int minimizeArrayValueerfen(int[] nums) {
        int right = (int) 1e9;
        int left = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            //假设  这个最大值是 mid  从后往前  如果能够承载
            if (check(mid, nums)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int mid, int[] nums) {
        long has = 0;
        for (int i : nums) {
            if (i <= mid) {
                has += mid - i;
            } else {
                if (i - mid > has) {
                    return false;
                } else {
                    has -= i - mid;
                }
            }
        }
        return true;
    }


    @Test
    public void t() {
        minimizeArrayValue(new int[]{3, 7, 1, 6});
    }
}
