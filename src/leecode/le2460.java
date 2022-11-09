package leecode;

/**
 * @Author hujf
 * @Date 2022/11/8 11:02
 * @Description
 *
 * 地
 */
public class le2460 {
    public int[] applyOperations(int[] nums) {
        int n = nums.length-1;
        for(int i=0;i<n;i++){
            if(nums[i]==nums[i+1]){
                nums[i] = nums[i]*2;
                nums[i+1] = 0;
            }
        }
        int [] a = new int[nums.length];
        int count =0;
        for(int i:nums){
            if(i!=0){
                a[count++] = i;
            }
        }
        return  a;
    }
}
