package leecode;

import org.junit.Test;

/**
 * @author Hujf
 * @title: le704
 * @date 2021/1/18 0018下午 8:22
 * @description: TODO
 */
public class le704 {

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(target<nums[mid]){
                end = mid-1;
            }else if (target>nums[mid]){
                start = mid+1
                ;
            }else {
                return mid;
            }
        }
        return -1;
    }
    @Test
    public void t(){
        search(new int[]{-1,0,3,5,9,12},2);
    }
}
