package leecode;

/**
 * @author Hujf
 * @title: le26
 * @date 2020/11/21 0021下午 3:35
 * @description: TODO
 */
public class le26 {

    public int removeDuplicates(int[] nums) {
        int start  = 1;
        int len = nums.length;
        int last= nums[0];
        for(int i=1;i<len;i++){
            if(last!=nums[i]){
                nums[start] =nums[i];
                start++;
            }
        }
        return start;
    }
}
