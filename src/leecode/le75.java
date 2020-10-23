package leecode;

/**
 * @author Hujf
 * @title: le75
 * @date 2020/10/7 0007上午 9:09
 * @description: TODO
 */
public class le75 {
    public void sortColors(int[] nums) {
        int local0 =0;
        int local2 = nums.length-1;
        for(int i=0;i<nums.length;i++){
            while (i <= local2 && nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[local2];
                nums[local2] = temp;
                local2--;
            }
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[local0];
                nums[local0] = temp;
                local0++;
            }
        }
    }

}
