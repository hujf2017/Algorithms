package 面试;

/**
 * @author Hujf
 * @title: of39
 * @date 2021/1/15 0015上午 10:35
 * @description: 超过一半
 */
public class of39 {

    public int majorityElement(int[] nums) {
        int n = 1;
        int last = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=last){
                n--;
            }else{
                n++;
            }
            if(n<0){
                last = nums[i];
                n=1;
            }
        }
        return last;
    }
}
