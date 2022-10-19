package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/10/19 10:10
 * @Description TODO
 */
public class le55 {
    public boolean canJump(int[] nums) {
        int max = 0;
        for(int i=0;i<nums.length;i++){
            if(max<i){
                return false;
            }
            max = Math.max(max,i+nums[i]);

        }
        return true;
    }

    @Test
    public void t(){

        canJump(new int[]{2,1,0,1});
    }
}
