package leecode;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author hujf
 * @Date 2022/7/29 14:09
 * @Description TODO
 */
public class le209 {

    public int minSubArrayLen(int target, int[] nums) {
        Deque<Integer> queue = new LinkedList();
        int count = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            queue.add(nums[i]);

            while (count >= target) {
                min = Math.min(min, queue.size());
                Integer integer = queue.pollFirst();
                count -= integer;
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }


    @Test
    public void t() {
        minSubArrayLen(11, new int[]{1, 2, 3, 4, 5});
    }
}
