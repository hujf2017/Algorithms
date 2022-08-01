package 比赛;

import java.util.Arrays;

/**
 * @Author hujf
 * @Date 2022/8/1 15:16
 * @Description TODO
 */
public class le2357 {
    public int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        int count =0;
        int last = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=last){
                last = nums[i];
                count++;
            }
        }

        return count;
    }
}
