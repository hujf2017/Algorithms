package leecode;

/**
 * @author Hujf
 * @title: le283
 * @date 2020/11/19 0019下午 7:25
 * @description: TODO
 */
public class le283 {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int frist =0;
        int secode =0;
        while (frist<len){
            if(nums[frist]!=0){
                nums[secode] = nums[frist];
                secode++;
            }
            frist++;
        }
        while(secode<len){
            nums[secode] =0 ;
            secode++;
        }
    }
}
