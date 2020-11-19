package leecode;

import java.util.Arrays;

/**
 * @author Hujf
 * @title: le287
 * @date 2020/11/19 0019下午 8:03
 * @description: TODO
 */
public class le287 {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int last = nums[0];
        for(int i=1;i<nums.length;i++){
            if(last ==nums[i]){
                return last;
            }
            last = nums[i];
        }
        return 0;
    }
}
