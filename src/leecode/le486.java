package leecode;

import org.junit.Test;

/**
 * @author Hujf
 * @title: le486
 * @date 2021-06-17 13:22
 * @description: 判断谁赢
 */
public class le486 {

    //方法一 用递归
    public boolean PredictTheWinner(int[] nums) {
        int num = dfs(nums, 0, nums.length - 1, 1);
        return  num>= 0;

    }

    private int dfs(int[] nums, int start, int end, int flag) {
        if (start == end) {
            return nums[start];
        }
        int starts = nums[start] * flag + dfs(nums, start + 1, end, -flag);
        int ends = nums[end] * flag + dfs(nums, start, end - 1, -flag);
        return Math.max(starts*flag, ends*flag)*flag;
    }

    @Test
    public void t(){
        PredictTheWinner(new int[]{4,2,10,5});
    }

}
