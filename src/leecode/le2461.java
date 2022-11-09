package leecode;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author hujf
 * @Date 2022/11/8 11:06
 * @Description 华东窗口
 */
public class le2461 {

    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(k);
        int start = 0;
        int[] cfu = new int[nums.length];
        long count = 0;
        while (start < k) {
            count += nums[start];
            if (map.containsKey(nums[start])) {
                cfu[start] = 1;
                map.put(nums[start], start);
            } else {
                map.put(nums[start], start);
            }
            start++;
        }
        long max = 0;
        if (map.size()==k&&cfu[k - 1] == 0) {
            max = count;
        }

        for (int i = k; i < nums.length; i++) {
            //先排除最前面一个
            if (map.containsKey(nums[i - k]) && map.get(nums[i - k]) == i - k) {
                map.remove(nums[i - k]);
            }

            count = count + nums[i] - nums[i - k];
            if (map.containsKey(nums[i])) {
                cfu[i] = 1;
                map.put(nums[i], i);
            } else {
                map.put(nums[i], i);
                if (map.size() == k && max < count) {
                    max = count;
                }
            }

        }
        return max;

    }

    @Test
    public void t() {
        maximumSubarraySum(new int[]{1,2,3,4,5,6,7,8}, 8);
    }
}
