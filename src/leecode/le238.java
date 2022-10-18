package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/10/18 11:00
 * @Description TODO
 */
public class le238 {
    public int[] productExceptSelf(int[] nums) {
        //包含自己和不包含自己
        int [] left = new int[nums.length];
        left[0] = 1;
        int []right = new int[nums.length];
        right[nums.length-1] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = nums[i-1]*left[i-1];
        }

        for (int j= nums.length-2; j>=0 ; j--) {
            right[j] = nums[j+1]*right[j+1];
        }
        int []num = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            num[i] = left[i]*right[i];
        }
        return  num;
    }

    @Test
    public void t(){
        int [] a = new int[]{1,2,3,4};
        productExceptSelf(a);
    }
}
