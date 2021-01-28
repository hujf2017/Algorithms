package leecode;

import org.junit.Test;

/**
 * @author Hujf
 * @title: le724
 * @date 2021/1/28 0028上午 8:43
 * @description: TODO
 */
public class le724 {
    public int pivotIndex(int[] nums) {
        if(nums.length==0){
            return -1;
        }
        int []nk = new int[nums.length];
        nk[0]=0;
        int []nk2 = new int[nums.length];
        nk2[nums.length-1]=0;
        for(int i=1;i<nums.length;i++){
            nk[i]=nk[i-1]+nums[i-1];
        }
        for(int i=nums.length-2;i>=0;i--){
            nk2[i]=nk2[i+1]+nums[i+1];
        }

        for(int i=0;i<nums.length;i++){
            if(nk[i]==nk2[i]){
                return nums[i];
            }
        }
        return -1;
    }
    @Test
    public void t(){
        pivotIndex(new int[]{1,7,3,6,5,6});
    }

}
