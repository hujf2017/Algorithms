package leecode;

import org.junit.Test;

/**
 * @author Hujf
 * @title: le31
 * @date 2020/11/10 0010下午 4:36
 * @description: 字典序的下一个排序
 */
public class le31 {
    public void nextPermutation(int[] nums) {
        int min = 0;
        int k = nums.length-1;
        for(int i=nums.length-1;i>=0;i--){
            for(int j=i-1;j>=0;j--){
                if(nums[i]>nums[j]){
                    if(min<j){
                        min = Math.max(j,min);
                        k = i;
                    }
                    break;
                }
            }
        }
        int tmp= nums[k];
        nums[k] = nums[min];
        nums[min] = tmp;
    }

    @Test
    public void t(){
        nextPermutation(new int[]{1,2,3,234,5,7,32,4,213,432,432,34,6});
    }
}
