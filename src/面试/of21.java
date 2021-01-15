package 面试;

/**
 * @author Hujf
 * @title: of21
 * @date 2021/1/15 0015上午 10:26
 * @description: TODO
 */
public class of21 {
        public int[] exchange(int[] nums) {
            //奇数在前 偶数在后
            int start = 0;
            int end = nums.length-1;
            while(start<end){
                //出现偶数
                if(nums[start]%2==0){
                    while(start<end&&nums[end]%2==0){
                        end--;
                    }
                    if(nums[end]%2==1){
                        int tmp = nums[start];
                        nums[start] = nums[end];
                        nums[end] = tmp;
                        end--;
                    }
                }
                start++;
            }
            return nums;
        }

}
