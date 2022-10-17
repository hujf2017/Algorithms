package leecode;

import javax.xml.ws.BindingType;

/**
 * @Author hujf
 * @Date 2022/10/12 17:54
 * @Description TODO
 */
public class le2369 {
    public boolean validPartition(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] - nums[i - 1];
        }
        //如果一开始就是1
        int i = 0;
        while (i < dp.length) {
            //是否满足三个递增
            //是否满足2个相同
            //是否满足三个相同

            i++;
        }
        return false;

    }

    public static void main(String[] args) {
        System.out.println();
    }
}
