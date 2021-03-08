package leecode;

import org.junit.Test;

/**
 * @author Hujf
 * @title: le503
 * @date 2021/3/6 0006下午 5:14
 * @description: TODO
 */
public class le503 {
    public int[] nextGreaterElements(int[] nums) {
        int []a = new int[nums.length*2];
        int []b = new int[nums.length];
        int c = 0;
        while(c<b.length) {
            boolean ax = false;
            for (int i = c+1; i < a.length*2; i++) {
                if(nums[i%nums.length]>nums[c]){
                    b[c] = nums[i%nums.length];
                    c++;
                    ax=true;
                    break;
                }
            }
            if(!ax){
                b[c]=-1;
                c++;
            }
        }
        return b;
    }

    @Test
    public void t(){
        nextGreaterElements(new int[]{1,2,1});
    }
}
