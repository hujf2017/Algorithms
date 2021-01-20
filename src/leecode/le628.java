package leecode;

import java.util.Arrays;

/**
 * @author Hujf
 * @title: le628
 * @date 2021/1/20 0020上午 8:32
 * @description: TODO
 */
public class le628 {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        return  Math.max(nums[0]*nums[1]*nums[len-1],nums[len-1]*nums[len-2]*nums[len-3]);
    }
}
