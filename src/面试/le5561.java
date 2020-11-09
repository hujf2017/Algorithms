package 面试;

import org.junit.Test;

/**
 * @author Hujf
 * @title: le5561
 * @date 2020/11/8 0008上午 10:34
 * @description: TODO
 */
public class le5561 {
    public int getMaximumGenerated(int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        int nums[] = new int[n+1];
        nums[0] = 0;
        nums[1] = 1;
        int i=0;
        int max = 0;
        for (; i <= n / 2; i++) {
            nums[2 * i] = nums[i];
            max = Math.max(max,nums[2 * i]);
            if(2 * i + 1<=n) {
                nums[2 * i + 1] = nums[i] + nums[i + 1];
                max = Math.max(max,nums[2 * i+1]);
            }

        }
       return max;
    }

    @Test
    public void t() {
        getMaximumGenerated(2);
    }
}
