package 面试;

/**
 * @author Hujf
 * @title: of53
 * @date 2021/1/14 0014下午 7:21
 * @description: TODO
 */
public class of53 {
    public int search(int[] nums, int target) {
        int left =0;
        int right = nums.length-1;
        int count=0;
        while(left<right){
            int mid = (left+right)/2;
            if(nums[mid]>=target){
                    right=mid;
            }
            if(nums[mid]<target){
                left = mid+1;
            }
        }
        while(left<nums.length&&nums[left++]==target) {
            count++;
        }
        return count;
    }
}
