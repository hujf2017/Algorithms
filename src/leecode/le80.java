package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/7/5 11:50
 * @Description TODO
 */
public class le80 {

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int slow = 2, fast = 2;

        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        return slow;
    }


    @Test
    public void t() {
        removeDuplicates(new int[]{
                1, 1, 1, 2, 2, 3
        });
    }
}
