package leecode;

import org.junit.Test;

/**
 * @author Hujf
 * @title: le27
 * @date 2021-04-1918:53
 * @description: TODO
 */
public class le27 {

    public int removeElement(int[] nums, int val) {
        int last = nums.length-1;
        int count =0;
        for(int i=0;i<=last;i++){
            if(nums[i]==val){
                nums[i]=nums[last];
                nums[last]=val;
                i--;
                last--;
                count++;
            }
        }
        return nums.length-count;
    }

    @Test
    public void t(){
        removeElement(new int[]{0},0);
    }
}
