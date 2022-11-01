package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/10/20 11:02
 * @Description TODO
 */
public class le136 {
    public int singleNumber(int[] nums) {
        int num1 =0;

        for(int i=0;i<nums.length;i++){

            num1 = num1^nums[i];
        }
        return num1;
    }

    @Test
    public void t(){
        System.out.println(singleNumber(new int[]{1, 1, 3, 4, 4}));
    }
}
