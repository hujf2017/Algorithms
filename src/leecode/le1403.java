package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author hujf
 * @Date 2022/8/4 9:11
 * @Description TODO
 */
public class le1403 {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> a = new ArrayList();
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        int count =0;
        for(int i=nums.length-1;i>=0;i--){
            count+=nums[i];
            a.add(nums[i]);
            if(count>sum-count){
                break;
            }
        }
        return a;
    }
}
