package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/6/29 17:49
 * @Description 桶排序
 */
public class le169 {
    public int majorityElement(int[] nums) {
        int numnow = nums[0];
        int has = 0;
        for(int i=0;i<nums.length;i++){
            if(has==0){
                numnow = nums[i];
                has++;
            }else{
                if(numnow!=nums[i]){
                    has--;
                }
            }
        }
        return numnow;
    }

    @Test
    public void t(){

    }
}
