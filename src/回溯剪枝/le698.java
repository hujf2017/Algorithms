package 回溯剪枝;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author hujf
 * @Date 2022/6/13 16:35
 * @Description TODO
 */
public class le698 {

    boolean t = false;
    int[] nums;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int[] num = new int[k];
        this.nums = nums;
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return t;
        }
        Arrays.sort(nums);
        dfs(num, nums.length - 1, sum / k);
        return t;
    }

    private void dfs(int[] num, int index, int k) {
        if (t) {
            return;
        }
        if (index < 0) {
            for (int b : num) {
                if (b != k) {
                    return;
                }
            }
            t = true;
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (i > 0 && num[i - 1] == num[i]) {
                continue;
            }
            num[i] += nums[index];
            if (num[i] <= k) {
                dfs(num, index - 1, k);
            }
            num[i] -= nums[index];
        }
    }

    @Test
    public void t() {
        canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4);
    }
}
