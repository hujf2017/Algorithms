package leecode;

/**
 * @author Hujf
 * @title: le35
 * @date 2020/11/20 0020上午 9:34
 * @description: TODO
 */
public class le35 {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        for(int i=0;i<len;i++){
            if(nums[i]>=target){
                return i;
            }
        }
        return len+1;

    }
}
