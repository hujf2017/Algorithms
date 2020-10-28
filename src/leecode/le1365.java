package leecode;

import org.junit.Test;

/**
 * @author Hujf
 * @title: le1365
 * @date 2020/10/26 0026上午 9:26
 * @description: TODO
 */
public class le1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int len = nums.length;
        int []a = new int[101];
        for(int i=0;i<nums.length;i++){
            a[nums[i]]+=1;
        }
        for(int i=1;i<101;i++){
            a[i]+=a[i-1];
        }
       int []ax= new int[len];
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                ax[i]=0;
            }else {
                ax[i] = a[nums[i] - 1];
            }
        }
        return ax;
    }

    @Test
    public void t(){
        smallerNumbersThanCurrent(new int[]{5,0,10,0,10,6});
    }
}
