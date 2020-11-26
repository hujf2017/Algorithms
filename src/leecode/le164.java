package leecode;

import java.util.Arrays;

/**
 * @author Hujf
 * @title: le164
 * @date 2020/11/26 0026下午 4:42
 * @description: TODO
 */
public class le164 {
    public int maximumGap(int[] nums) {
        if(nums.length<2){
            return 0;
        }

        Arrays.sort(nums);
        int max =0;
        int last = nums[0];

        for(int i=1;i<nums.length;i++){
            max = Math.max(max,nums[i]-last);
            last = nums[i];
        }
        return max;
    }
}
