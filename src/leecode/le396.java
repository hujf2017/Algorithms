package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/8/16 9:36
 * @Description TODO
 */
public class le396 {
    public int maxRotateFunction(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        int k = nums.length;
        int bzz = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            bzz += nums[i];
            max += i * nums[i];
        }
        //当前中间段
        bzz = bzz  - nums[end];
        int last = max;
        //移动
        for (int i = 1; i < nums.length; i++) {
            //下个递进  直接加上头尾
            int local = last +bzz -  nums[end]*(k-1);
           //但是要减去 上一个
            bzz+=nums[end];
            start = (start +nums.length-1)%nums.length;
            end = (end - 1) % nums.length;
            bzz-=nums[end];
            max = Math.max(local,max);
            last = local;
        }
        return max;

    }


    @Test
    public void t() {
        maxRotateFunction(new int[]{4, 3, 2, 6});
    }
}
