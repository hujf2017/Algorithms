package 排序;

/**
 * @author Hujf
 * @title: 找到中位数
 * @date 2021-08-09 14:34
 * @description: TODO
 */
public class 找到中位数 {
    static int[] nums = {1, 6, 3, 3, 5, 67, 7, 5, 3, 2};

    public static void main(String[] args) {
        System.out.println( findMiddleByPartition(nums, 0, 9));
    }

    private static int findMiddleByPartition(int[] nums, int left, int right) {
        int i = left, j = right;
        int key = nums[left];
        while (i < j) {
            while (i < j && nums[j] >= key) {
                j--;
            }
            if (i < j) {
                nums[i] = nums[j];
                i++;
            }
            while(i<j&&nums[i]<=key){
                i++;
            }
            if(i<j){
                nums[j] = nums[i];
                j--;
            }
        }
        nums[i] = key;
        if(i==nums.length/2){
           return i;
        }else if(i<nums.length/2){
            return findMiddleByPartition(nums, i + 1, right);
        }else{
            return findMiddleByPartition(nums,left,i-1);
        }


    }
}
